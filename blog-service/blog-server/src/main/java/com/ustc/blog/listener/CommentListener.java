package com.ustc.blog.listener;

import com.ustc.blog.mapper.BlogGeneralMapper;
import com.ustc.blog.service.RankService;
import com.ustc.comment.sdk.CommentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.ustc.comment.sdk.MqConstants.*;

/**
 * 监听Comment模块的消息
 * <p>
 * todo 取消的动作也是需要减分的，参考BlogListener
 *
 * @author css
 */
@Slf4j
@Component
public class CommentListener {

    private static final String COMMENT_INCREASE_QUEUE = "blog.comment.increase";

    private static final String COMMENT_DECREASE_QUEUE = "blog.comment.decrease";

    @Resource
    private BlogGeneralMapper blogGeneralMapper;

    @Resource
    private RankService rankService;

    /**
     * 博客评论数量增加
     *
     * @param comment 博客评论传输对象
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = COMMENT_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = COMMENT_INCREASE_QUEUE),
            key = BLOG_COMMENT_INCREASE_KEY
    ))
    public void commentNumberIncreaseListener(CommentDTO comment) {
        // 增加博客的评论数量
        log.debug("{} 评论数量+1", comment.getBlogId());
        blogGeneralMapper.increaseCommentNum(comment.getBlogId());
        // 博客热度加 3
        rankService.increaseRankHotScore(comment.getBlogId(), 3d);
        // 作者热度加 3
        rankService.increaseRankAuthorScore(comment.getBlogId(), 3d);

    }

    /**
     * 博客评论数量减少
     *
     * @param comment 博客评论传输对象
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = COMMENT_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = COMMENT_DECREASE_QUEUE),
            key = BLOG_COMMENT_DECREASE_KEY
    ))
    public void commentNumberDecreaseListener(CommentDTO comment) {
        // 减少博客的评论数量
        log.debug("{} 评论数量-1", comment.getBlogId());
        blogGeneralMapper.decreaseCommentNum(comment.getBlogId());
        // 博客和作者热度 减少
        rankService.increaseRankHotScore(comment.getBlogId(), -3d);
        rankService.increaseRankAuthorScore(comment.getBlogId(), -3d);
    }

}
