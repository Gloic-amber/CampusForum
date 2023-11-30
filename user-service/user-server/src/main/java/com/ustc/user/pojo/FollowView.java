package com.ustc.user.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: FollowView
 * Package: com.ustc.user.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:22
 * @Version 1.0
 */
@Data
public class FollowView {

    /**
     * id
     */
    Integer id;

    /**
     * 用户id
     */
    Integer userId;

    /**
     * 关注者id
     */
    Integer followId;

    /**
     * 备注
     */
    String note;

    /**
     * 关注状态码
     */
    Integer status;

    /**
     * 创建时间
     */
    Timestamp createTime;

    /**
     * 关注者用户名
     */
    String username;

    /**
     * 关注者昵称
     */
    String nickname;

    /**
     * 关注者院校代码
     */
    Integer schoolCode;

    /**
     * 关注者头像链接
     */
    String avatarUrl;

    /**
     * 关注者注册时间
     */
    Timestamp registerTime;

}
