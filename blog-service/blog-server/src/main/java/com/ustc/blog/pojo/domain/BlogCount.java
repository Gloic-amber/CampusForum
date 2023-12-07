package com.ustc.blog.pojo.domain;

import lombok.Data;

/**
 * @author css
 */
@Data
public class BlogCount {

	/**
	 * 状态码
	 */
	Integer status;

	/**
	 * 当前状态对应的数量
	 */
	Integer number;

}
