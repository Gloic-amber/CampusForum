package com.ustc.blog.sdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 使用 rabbitMQ 传输具体用户对某篇博客进行操作的事件实体类
 *
 * @author css
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogOperateDTO {

    /**
     * 被操作的博客id
     */
    Integer blogId;

    /**
     * 执行的用户id，可能为空
     */
    Integer userId;

    /**
     * 博客作者id
     */
    Integer authorId;

}
