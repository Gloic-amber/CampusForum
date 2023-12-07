package com.ustc.blog.content;

import com.ustc.common.redis.autoconfig.EnableRedisSerialize;
import com.ustc.common.web.advice.EnableDefaultExceptionAdvice;
import com.ustc.common.web.advice.EnableDefaultResponseAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author css
 */
@EnableRedisSerialize
@EnableFeignClients(basePackages = "com.ustc.user.client")
@SpringBootApplication
@EnableDefaultExceptionAdvice
@EnableDefaultResponseAdvice
public class BlogContentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogContentServerApplication.class, args);
    }

}
