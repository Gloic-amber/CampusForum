package com.ustc.blog.utils;

import com.ustc.blog.pojo.domain.Blog;
import com.ustc.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

import static com.ustc.blog.sdk.BlogMqConstants.BLOG_REFRESH_ES_KEY;
import static com.ustc.blog.sdk.BlogMqConstants.BLOG_TOPIC_EXCHANGE;

/**
 * @author 阿杆
 * @version 1.0
 * @date 2023/5/12 23:30
 */
@Slf4j
@Component
public class BlogContentUtils {

	@Resource
	BlogService blogService;

	@Resource
	RabbitTemplate rabbitTemplate;

	/**
	 * 重置所有ES中的博客数据
	 */
	public void refreshBlogs() {
		// 先获取所有博客数据
		List<Blog> blogList = blogService.list();
		log.info("共获取到{}条博客数据", blogList.size());
		// 发送MQ消息
		rabbitTemplate.convertAndSend(BLOG_TOPIC_EXCHANGE, BLOG_REFRESH_ES_KEY, blogList);
	}

}
