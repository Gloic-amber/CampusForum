package com.ustc.blog.content.listener;

import com.ustc.blog.content.mapper.BlogRepository;
import com.ustc.blog.content.pojo.BlogDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;

import static com.ustc.blog.sdk.BlogMqConstants.*;

/**
 * 博客服务消息队列监听器
 *
 * @author css
 */
@Slf4j
@Component
public class BlogServerListener {

    /**
     * 保存博客队列
     */
    private static final String BLOG_SAVE_QUEUE = "blog.save.es.queue";

    /**
     * 重置ES博客队列
     */
    private static final String BLOG_REFRESH_QUEUE = "blog.refresh.es.queue";

    /**
     * 删除博客队列
     */
    private static final String BLOG_DELETE_QUEUE = BLOG_DELETE_KEY + ".es.queue";

    @Resource
    private BlogRepository blogRepository;

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = BLOG_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = BLOG_SAVE_QUEUE),
            key = {BLOG_INSERT_KEY, BLOG_UPDATE_KEY}
    ))
    public void saveListener(BlogDoc blogDoc) {
        log.debug("save blogDoc，{}", blogDoc);
        blogRepository.save(blogDoc);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = BLOG_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = BLOG_REFRESH_QUEUE),
            key = BLOG_REFRESH_ES_KEY
    ))
    public void refreshBlog(List<BlogDoc> blogDocs) {
        log.debug("导入数量：{}", blogDocs.size());
        blogRepository.saveAll(blogDocs);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = BLOG_TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
            value = @Queue(name = BLOG_DELETE_QUEUE),
            key = BLOG_DELETE_KEY
    ))
    public void deleteListener(Long blogId) {
        log.debug("delete blog ,id->{}", blogId);
        blogRepository.deleteById(blogId);
    }

}