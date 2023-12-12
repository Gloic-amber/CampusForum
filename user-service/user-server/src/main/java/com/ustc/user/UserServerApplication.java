package com.ustc.user;

import com.ustc.common.redis.autoconfig.EnableRedisSerialize;
import com.ustc.common.tool.mybatisconfig.EnableMybatisPlusIPage;
import com.ustc.common.web.advice.EnableDefaultExceptionAdvice;
import com.ustc.common.web.advice.EnableDefaultResponseAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: UserServerApplication
 * Package: com.ustc.user
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:11
 * @Version 1.0
 */

@SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
@SpringBootApplication
@EnableAsync // 开启异步控制
@EnableFeignClients(basePackages = {"com.ustc.resource.client", "com.ustc.blog.client"}) // 开启feign
@EnableMybatisPlusIPage // 开启mybatis分页助手
@EnableRedisSerialize // 开启RedisTemplate序列化配置
@EnableScheduling // 开启定时任务
@EnableDefaultExceptionAdvice // 注入默认异常处理器
@EnableDefaultResponseAdvice // 注入默认包装器
public class UserServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
