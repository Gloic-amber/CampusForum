package com.ustc.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ustc.common.exception.MapperException;
import com.ustc.common.regex.RegexUtils;
import com.ustc.common.result.RestResult;
import com.ustc.common.tool.utils.RandomUtils;
import com.ustc.resource.client.MessageClient;
import com.ustc.resource.client.pojo.MailDTO;
import com.ustc.user.config.UserConfig;
import com.ustc.user.mapper.UserGeneralMapper;
import com.ustc.user.mapper.UserMapper;
import com.ustc.user.mapper.UserSafetyMapper;
import com.ustc.user.pojo.User;
import com.ustc.user.pojo.UserGeneral;
import com.ustc.user.pojo.UserRegisterBO;
import com.ustc.user.pojo.UserSafety;
import com.ustc.user.service.RegisterService;
import com.ustc.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import static com.ustc.user.utils.RedisConstants.REGISTER_MAIL_CODE_KEY;
import static com.ustc.user.utils.RedisConstants.REGISTER_MAIL_CODE_TTL;

/**
 * ClassName: RegisterServiceImpl
 * Package: com.ustc.user.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterServiceImpl extends ServiceImpl<UserSafetyMapper, UserSafety> implements RegisterService {

    @Resource
    private UserSafetyMapper userSafetyMapper;

    @Resource
    private MessageClient messageClient;

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserGeneralMapper userGeneralMapper;

    @Override
    public RestResult<Object> sendMailVerify(String mailAddress) {
        // 1.校验邮箱
        if (!RegexUtils.isEmailInvalid(mailAddress)) {
            // 1.2.如果不符合，返回错误信息
            return RestResult.fail("不存在的邮箱");
        }
        // 2.检查上一次发送时间，此处并未记录真实发送时间，仅通过验证码的ttl来判断
        String key = REGISTER_MAIL_CODE_KEY + mailAddress;
        int sendCodeInterval = 60;
        Long keyExpire = stringRedisTemplate.getExpire(key);
        log.debug("check REGISTER_MAIL_CODE_TTL,{}", keyExpire);
        if (keyExpire != null && REGISTER_MAIL_CODE_TTL - keyExpire < sendCodeInterval) {
            // 2.1不合符，拒绝发送
            return RestResult.fail("发送频繁");
        }
        // 3.检查邮箱是否已经被注册
        if (userSafetyMapper.selectByMail(mailAddress) != null) {
            return RestResult.fail("该邮箱已被注册");
        }
        // 4.满足条件，生成验证码
        String code = RandomUtils.randomNumber(6).toString();
        // 4.1.存入redis
        stringRedisTemplate.opsForValue().set(key, code, REGISTER_MAIL_CODE_TTL, TimeUnit.SECONDS);
        // 5.发送邮件
        MailDTO mailDTO = new MailDTO();
        mailDTO.setFrom("校园博客");
        mailDTO.setTo(mailAddress);
        mailDTO.setSubject("校园博客注册验证码");
        mailDTO.setText("亲爱的用户：\n" + "你正在注册校园博客，你的邮箱验证码为：" + code + "，此验证码有效时长5分钟，请勿转发他人。");
        // 发送邮件return
        messageClient.sendMail(mailDTO);
        return RestResult.ok();
    }

    @Override
    public RestResult<Object> register(UserRegisterBO userRegisterBO) {
        // 1. 检查验证码是否正确
        // 由于邮件服务还未使用，因此暂时不用邮箱验证码
//        if (!checkMailVerify(userRegisterBO.getMail(), userRegisterBO.getMailVerify())) {
//            return RestResult.fail("验证码错误");
//        }
        // 2.检查用户名是否已经存在
        if (userService.getByUsername(userRegisterBO.getUsername()) != null) {
            return RestResult.fail("用户名已存在");
        }
        // 3.检查手机号是否存在，因为暂时没有核实手机号码的验证码，所以就先将就一下
        String mobile = userRegisterBO.getMobile();
        if (mobile == null || lambdaQuery().eq(UserSafety::getMobile, mobile).exists()) {
            return RestResult.fail("该手机号已被注册");
        }
        // 4.检查完毕，插入数据
        User user = new User();
        user.setSchoolCode(userRegisterBO.getSchoolCode());
        user.setUsername(userRegisterBO.getUsername());
        user.setNickname(userRegisterBO.getUsername());
        user.setAvatarUrl(UserConfig.DefaultAvatar);
        user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        if (userMapper.insert(user) != 1) {
            throw new MapperException("注册失败，信息异常", user);
        }
        log.info("新用户注册：id->{}", user.getId());
        UserSafety userSafety = new UserSafety();
        BeanUtils.copyProperties(userRegisterBO, userSafety);
        userSafety.setUserId(user.getId());
        // 5. 密码加密后再存入数据库
        userSafety.setPassword(passwordEncoder.encode(userRegisterBO.getPassword()));
        if (userSafetyMapper.insert(userSafety) != 1) {
            throw new MapperException("注册失败，信息异常", userSafety);
        }
        // 6.从redis中删除验证码
        stringRedisTemplate.delete(REGISTER_MAIL_CODE_KEY + userRegisterBO.getMail());
        // 7. 增加用户数据统计表数据
        UserGeneral userGeneral = new UserGeneral();
        userGeneral.setUserId(user.getId());
        if (userGeneralMapper.insert(userGeneral) != 1) {
            throw new MapperException("注册失败，信息异常", userGeneral);
        }
        return RestResult.ok();
    }

    /**
     * 验证码检查
     *
     * @param mailAddress 邮件地址
     * @param code        待核对的验证码
     * @return 验证结果，成功或失败
     */
    private boolean checkMailVerify(@Valid @NotNull String mailAddress, @NotNull String code) {
        // 此处读取缓存中的数据
        String key = REGISTER_MAIL_CODE_KEY + mailAddress;
        String verify = stringRedisTemplate.opsForValue().get(key);
        return code.equals(verify);
    }

}
