package com.ustc.user.controller;

import com.ustc.common.exception.BusinessException;
import com.ustc.user.config.JwtConfig;
import com.ustc.user.pojo.UserLoginBO;
import com.ustc.user.service.LoginService;
import com.ustc.user.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * ClassName: LoginController
 * Package: com.ustc.user.controller
 * Description:  用户登录
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/login")
@Validated
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private HttpServletResponse response;

    /**
     * 用户登录
     *
     * @param username 账号
     * @param password 密码
     */
    @PostMapping("/login")
    public UserLoginBO loginHandle(@NotNull String username, @NotNull String password) {
        UserLoginBO user = loginService.login(username, password);
        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }
        response.setHeader(JwtConfig.headerName, JwtUtils.createToken("id", user.getId()));
        response.setHeader("Access-Control-Expose-Headers", JwtConfig.headerName);
        // 院校代码放到cookie去
        Cookie cookie = new Cookie("schoolCode", user.getSchoolCode().toString());
        cookie.setMaxAge(3600 * 7);
        response.addCookie(cookie);
        return user;
    }

}
