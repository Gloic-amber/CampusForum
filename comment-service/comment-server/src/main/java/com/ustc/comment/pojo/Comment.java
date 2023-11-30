package com.ustc.comment.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: Comment
 * Package: com.ustc.comment.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Data
public class Comment {

    /**
     * 评论id
     */
    Integer id;

    /**
     * 用户id
     */
    Integer userId;

    /**
     * 博客id
     */
    Integer blogId;

    /**
     * 评论内容
     */
    String content;

    /**
     * 父评论id
     */
    Integer parentId;

    /**
     * 回复的用户id
     */
    Integer parentUserId;

    /**
     * 创建时间
     */
    Timestamp createTime;

    /**
     * 是否已经删除，0未删除，1已删除
     */
    Integer deleted;

}
