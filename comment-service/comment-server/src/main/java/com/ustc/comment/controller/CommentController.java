package com.ustc.comment.controller;

import com.ustc.comment.pojo.Comment;
import com.ustc.comment.pojo.CommentListVO;
import com.ustc.comment.service.CommentService;
import com.ustc.common.exception.BusinessException;
import com.ustc.common.web.auth.AuthHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ClassName: CommentController
 * Package: com.ustc.comment.controller
 * Description: 评论相关
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @param comment 必须传入被评论的博客id和评论内容
     */
    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        if (comment.getBlogId() == null || comment.getContent() == null) {
            throw new BusinessException();
        }
        comment.setUserId(id);
        commentService.create(comment);
    }

    /**
     * 删除评论
     *
     * @param id 评论id
     */
    @DeleteMapping
    public void deleteComment(@RequestParam Integer id) {
        Integer userId = AuthHelper.getCurrentUserIdOrExit();
        commentService.checkAndDelete(userId, id);
    }

    /**
     * 获取评论列表
     *
     * @param blogId 评论的博客id
     */
    @GetMapping("/list")
    public CommentListVO getCommentList(@RequestParam Integer blogId, @RequestParam Integer page, @RequestParam(defaultValue = "3") Integer pageSize) {
        return commentService.getList(blogId, page, pageSize);
    }

}
