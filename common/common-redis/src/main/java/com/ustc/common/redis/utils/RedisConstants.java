package com.ustc.common.redis.utils;

/**
 * ClassName: RedisConstants
 * Package: com.ustc.common.redis.utils
 * Description: 常量
 *
 * @Author Gloic
 * @Create 2023/11/28 15:16
 * @Version 1.0
 */
public class RedisConstants {
    public static final Long CACHE_NULL_TTL = 120L;

    public static final String CACHE_LOCK_KEY = "lock:";

    public static final Long CACHE_LOCK_TTL = 10L;
}
