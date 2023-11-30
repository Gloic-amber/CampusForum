package com.ustc.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.comment.pojo.Comment;
import com.ustc.comment.pojo.CommentListVO;

/**
 * ClassName: CommentService
 * Package: com.ustc.comment.service
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
public interface CommentService extends IService<Comment> {

    /**
     * 创建评论
     *
     * @param comment 评论信息
     */
    void create(Comment comment);

    /**
     * 检查发表人并删除评论
     *
     * @param userId    用户id
     * @param commentId 评论id
     */
    void checkAndDelete(int userId, int commentId);

    /**
     * 获取评论信息列表
     *
     * @param blogId   博客id
     * @param page     当前页
     * @param pageSize 页大小
     * @return 评论信息列表视图
     */
    CommentListVO getList(int blogId, int page, int pageSize);

}
