package com.ustc.user.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: UserDTO
 * Package: com.ustc.user.dto
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:06
 * @Version 1.0
 */
@Data
public class UserDTO {

    /**
     * 用户id
     */
    Integer id;

    /**
     * 用户名
     */
    String username;

    /**
     * 用户昵称
     */
    String nickname;

    /**
     * 院校代码
     */
    Integer schoolCode;

    /**
     * 头像链接
     */
    String avatarUrl;

    /**
     * 注册时间
     */
    Timestamp registerTime;

}
