package com.ustc.gateway.config;

import com.ustc.gateway.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: GatewayConfig
 * Package: com.ustc.gateway.config
 * Description: 网关配置
 *
 * @Author Gloic
 * @Create 2023/11/28 16:49
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
public class GatewayConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}
