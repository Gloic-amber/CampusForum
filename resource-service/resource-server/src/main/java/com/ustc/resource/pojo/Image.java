package com.ustc.resource.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: Image
 * Package: com.ustc.resource.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Data
public class Image {

    /**
     * 图片id
     */
    Integer id;

    /**
     * 图片链接
     */
    String url;

    /**
     * 访问次数
     */
    Integer visit;

    /**
     * 修改时间
     */
    Timestamp modifiedTime;

    /**
     * 创建时间
     */
    Timestamp createTime;

}
