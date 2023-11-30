package com.ustc.user.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * ClassName: UserRegisterBO
 * Package: com.ustc.user.pojo
 * Description: 用户注册业务类
 *
 * @Author Gloic
 * @Create 2023/11/30 11:27
 * @Version 1.0
 */
@Data
public class UserRegisterBO {

    /**
     * 用户名
     */
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$", message = "用户名不合符要求")
    String username;

    /**
     * 密码
     */
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*?_-]{5,20}$", message = "密码不合符要求")
    String password;

    /**
     * 邮箱
     */
    @NotNull
    @Email
    String mail;

    /**
     * 手机号
     */
    @NotNull
    @Length(min = 11, max = 11, message = "手机号错误")
    String mobile;

    /**
     * 邮箱验证码
     */
    @NotBlank(message = "邮箱验证码不能为空")
    String mailVerify;

    /**
     * 院校代码
     */
    @NotNull(message = "院校代码不能为空")
    @Range(min = 300, max = 99999, message = "院校代码异常")
    Integer schoolCode;

}