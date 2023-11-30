package com.ustc.resource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: QiNiuConfig
 * Package: com.ustc.resource.config
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuConfig {

    String accessKey;

    String secretKey;

    String prefixUrl;

}
