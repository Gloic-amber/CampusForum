package com.ustc.comment.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: CommentBO
 * Package: com.ustc.comment.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentBO extends Comment {

    /**
     * 发表评论的用户的昵称
     */
    String nickname;

    /**
     * 头像链接
     */
    String avatarUrl;

    /**
     * 回复的用户昵称
     */
    String parentNickname;

}