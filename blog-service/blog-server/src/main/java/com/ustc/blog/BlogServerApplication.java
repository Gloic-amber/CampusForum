package com.ustc.blog;

import com.ustc.common.amqp.autoconfig.EnableAmqpMessageConverterConfig;
import com.ustc.common.redis.autoconfig.EnableRedisSerialize;
import com.ustc.common.tool.mybatisconfig.EnableMybatisPlusIPage;
import com.ustc.common.web.advice.EnableDefaultExceptionAdvice;
import com.ustc.common.web.advice.EnableDefaultResponseAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author css
 */
@SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.ustc.resource.client", "com.ustc.user.client"}) // 开启feign
@EnableMybatisPlusIPage // 开启mybatis分页
@EnableRedisSerialize
@EnableAmqpMessageConverterConfig
@EnableDefaultExceptionAdvice
@EnableDefaultResponseAdvice
public class BlogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

}
