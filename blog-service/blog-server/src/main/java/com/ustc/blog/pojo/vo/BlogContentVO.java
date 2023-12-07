package com.ustc.blog.pojo.vo;

import com.ustc.blog.pojo.bo.BlogStatusBO;
import com.ustc.blog.pojo.domain.BlogContentHtml;
import com.ustc.user.dto.UserDTO;
import lombok.Data;

/**
 * @author css
 */
@Data
public class BlogContentVO {

	/**
	 * 博客基本信息,带用户状态
	 */
	BlogStatusBO info;

	/**
	 * 博客内容信息
	 */
	BlogContentHtml content;

	/**
	 * 作者信息
	 */
	UserDTO author;

}
