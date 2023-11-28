package com.ustc.common.redis.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: RedisData
 * Package: com.ustc.common.redis.utils
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 15:17
 * @Version 1.0
 */
@Data
public class RedisData {

    LocalDateTime expireTime;

    Object data;

}
