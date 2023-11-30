package com.ustc.user.service;

import com.ustc.user.pojo.UserLoginBO;

/**
 * ClassName: LoginService
 * Package: com.ustc.user.service
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
public interface LoginService {
    /**
     * 用户登录服务
     *
     * @param username 用户名
     * @param password 密码
     * @return 匹配到的信息
     */
    UserLoginBO login(String username, String password);
}
