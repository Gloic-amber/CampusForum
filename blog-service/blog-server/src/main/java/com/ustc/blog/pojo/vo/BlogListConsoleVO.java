package com.ustc.blog.pojo.vo;

import com.ustc.blog.pojo.bo.BlogCountBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author css
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogListConsoleVO extends BlogListVO {

	/**
	 * 各状态博客数量
	 */
	BlogCountBO count;

}
