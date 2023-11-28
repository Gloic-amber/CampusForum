package com.ustc.common.amqp.autoconfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableAmqpMessageConverterConfig
 * Package: com.ustc.common.amqp.autoconfig
 * Description: 启用该注解时，便会导入AmqpMessageConverterConfig配置类，从而创建并注册messageConverter
 *
 * @Author Gloic
 * @Create 2023/11/28 14:25
 * @Version 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AmqpMessageConverterConfig.class)
public @interface EnableAmqpMessageConverterConfig {
}
