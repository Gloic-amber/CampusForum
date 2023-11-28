package com.ustc.gateway.utils;

/**
 * ClassName: RedisConstants
 * Package: com.ustc.gateway.utils
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 16:48
 * @Version 1.0
 */
public class RedisConstants {

    public static final String GATEWAY_IPLIMIT_KEY = "gateway:ipLimit:";

    public static final Long GATEWAY_IPLIMIT = 30L;

    public static final Long GATEWAY_IPLIMIT_TTL = 10L;

}