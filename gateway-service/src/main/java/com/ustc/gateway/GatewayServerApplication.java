package com.ustc.gateway;

import com.ustc.common.redis.autoconfig.EnableRedisSerialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: GatewayServerApplication
 * Package: com.ustc.gateway
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 16:46
 * @Version 1.0
 */
@EnableRedisSerialize
@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

}
