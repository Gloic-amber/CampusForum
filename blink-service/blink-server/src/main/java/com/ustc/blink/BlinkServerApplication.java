package com.ustc.blink;

import com.ustc.common.tool.mybatisconfig.EnableMybatisPlusIPage;
import com.ustc.common.web.advice.EnableDefaultExceptionAdvice;
import com.ustc.common.web.advice.EnableDefaultResponseAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author css
 */
@SpringBootApplication
@EnableMybatisPlusIPage
@EnableDefaultExceptionAdvice
@EnableDefaultResponseAdvice
@EnableFeignClients(basePackages = {"com.ustc.user.client"})
public class BlinkServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlinkServerApplication.class, args);
    }

}