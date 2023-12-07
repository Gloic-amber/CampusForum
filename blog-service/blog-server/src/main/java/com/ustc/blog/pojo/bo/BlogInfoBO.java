package com.ustc.blog.pojo.bo;

import com.ustc.blog.pojo.domain.BlogView;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author css
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogInfoBO extends BlogView {

	/**
	 * 作者昵称
	 */
	String authorName;

}
