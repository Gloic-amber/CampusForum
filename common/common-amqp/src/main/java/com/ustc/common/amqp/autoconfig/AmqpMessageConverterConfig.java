package com.ustc.common.amqp.autoconfig;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: AmqpMessageConverterConfig
 * Package: com.ustc.common.amqp.autoconfig
 * Description: 装配json和java对象的消息转换器的类
 *
 * @Author Gloic
 * @Create 2023/11/28 14:10
 * @Version 1.0
 */

@Configuration
public class AmqpMessageConverterConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
