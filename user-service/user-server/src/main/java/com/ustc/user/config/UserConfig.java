package com.ustc.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: UserConfig
 * Package: com.ustc.user.config
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:17
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties("user")
public class UserConfig {

    public static String DefaultAvatar;

    public void setDefaultAvatar(String defaultAvatar) {
        DefaultAvatar = defaultAvatar;
    }

}
