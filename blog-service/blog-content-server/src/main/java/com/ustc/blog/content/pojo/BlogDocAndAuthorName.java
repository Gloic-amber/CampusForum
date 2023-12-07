package com.ustc.blog.content.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author css
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogDocAndAuthorName extends BlogDoc {

    /**
     * 作者昵称
     */
    String authorName;

}
