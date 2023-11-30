package com.ustc.resource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: ResourcePath
 * Package: com.ustc.resource.config
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "resource.path")
public class ResourcePath {

    public static String avatarBucket;

    public static String imageBucket;

    public static String imageUrlBase;

    public void setAvatarBucket(String avatarBucket) {
        ResourcePath.avatarBucket = avatarBucket;
    }

    public void setImageBucket(String imageBucket) {
        ResourcePath.imageBucket = imageBucket;
    }

    public void setImageUrlBase(String imageUrlBase) {
        ResourcePath.imageUrlBase = imageUrlBase;
    }

}
