package com.ustc.common.redis.autoconfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableRedisSerialize
 * Package: com.ustc.common.redis.autoconfig
 * Description: redis默认序列化开关
 *
 * @Author Gloic
 * @Create 2023/11/28 15:10
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisSerializeDefaultConfig.class)
public @interface EnableRedisSerialize {

}
