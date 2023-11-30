package com.ustc.comment;

import com.ustc.common.tool.mybatisconfig.EnableMybatisPlusIPage;
import com.ustc.common.web.advice.EnableDefaultExceptionAdvice;
import com.ustc.common.web.advice.EnableDefaultResponseAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName: CommentServerApplication
 * Package: com.ustc.comment
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@SpringBootApplication
@EnableMybatisPlusIPage
@EnableFeignClients(basePackages = {"com.ustc.blog.client", "com.ustc.user.client"})
@EnableDefaultExceptionAdvice
@EnableDefaultResponseAdvice
public class CommentServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentServerApplication.class, args);
    }

}
