package com.ustc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ustc.common.result.RestResult;
import com.ustc.resource.client.ResourceClient;
import com.ustc.user.mapper.UserSafetyMapper;
import com.ustc.user.mapper.UserViewMapper;
import com.ustc.user.pojo.UserLoginBO;
import com.ustc.user.pojo.UserSafety;
import com.ustc.user.pojo.UserView;
import com.ustc.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * ClassName: LoginServiceImpl
 * Package: com.ustc.user.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserSafetyMapper userSafetyMapper;

    @Resource
    private PasswordEncoder encoder;

    @Resource
    private UserViewMapper userViewMapper;

    @Resource
    private ResourceClient resourceClient;

    @Override
    public UserLoginBO login(String username, String password) {
        LambdaQueryWrapper<UserSafety> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserSafety::getUsername, username);
        UserSafety user = userSafetyMapper.selectOne(wrapper);
        if (Objects.nonNull(user) && encoder.matches(password, user.getPassword())) {
            // 查询用户信息
            UserView userView = userViewMapper.selectById(user.getUserId());
            // 查询院校名称
            UserLoginBO userLoginBO = new UserLoginBO();
            BeanUtils.copyProperties(userView, userLoginBO);
            RestResult<String> universityName = resourceClient.getUniversityName(userView.getSchoolCode());
            userLoginBO.setSchoolName(universityName.getData());
            return userLoginBO;
        }
        return null;
    }
}
