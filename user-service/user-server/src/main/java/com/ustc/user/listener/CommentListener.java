package com.ustc.user.listener;

import com.ustc.comment.sdk.CommentDTO;
import com.ustc.user.mapper.UserGeneralMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.ustc.blog.sdk.BlogMqConstants.BLOG_TOPIC_EXCHANGE;
import static com.ustc.comment.sdk.MqConstants.BLOG_COMMENT_DECREASE_KEY;
import static com.ustc.comment.sdk.MqConstants.BLOG_COMMENT_INCREASE_KEY;

/**
 * ClassName: CommentListener
 * Package: com.ustc.user.listener
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Component
public class CommentListener {

    public static final String USER_COMMENT_QUEUE = "user.operate.comment";

    public static final String USER_COMMENT_QUEUE_CANCEL = "user.operate.comment.cancel";

    @Resource
    private UserGeneralMapper userGeneralMapper;

    /**
     * 用户评论博客
     *
     * @param commentDTO 评论操作操作消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = BLOG_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = USER_COMMENT_QUEUE),
            key = BLOG_COMMENT_INCREASE_KEY
    ))
    public void commentAddUserGeneral(CommentDTO commentDTO) {
        log.debug("用户 {} 评论加1", commentDTO.getAuthorId());
        userGeneralMapper.updateCommentNumByUserId(commentDTO.getAuthorId(), 1);

    }

    /**
     * 用户删除评论
     *
     * @param commentDTO 评论操作操作消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = BLOG_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = USER_COMMENT_QUEUE_CANCEL),
            key = BLOG_COMMENT_DECREASE_KEY
    ))
    public void commentreduceUserGeneral(CommentDTO commentDTO) {
        log.debug("用户 {} 评论 -1", commentDTO.getAuthorId());
        userGeneralMapper.updateCommentNumByUserId(commentDTO.getAuthorId(), -1);

    }

}
