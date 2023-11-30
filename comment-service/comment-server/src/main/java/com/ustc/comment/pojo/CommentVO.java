package com.ustc.comment.pojo;

import lombok.Data;

import java.util.List;

/**
 * ClassName: CommentVO
 * Package: com.ustc.comment.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Data
public class CommentVO {

    /**
     * 父评论信息
     */
    CommentBO info;

    /**
     * 子评论信息列表
     */
    List<CommentBO> sub;

    /**
     * 子评论信息条数
     */
    Long subCount;

}
