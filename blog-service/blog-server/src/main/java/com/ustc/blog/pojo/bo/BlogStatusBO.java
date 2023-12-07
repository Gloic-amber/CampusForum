package com.ustc.blog.pojo.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author css
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogStatusBO extends BlogInfoBO {

	/**
	 * 点赞收藏等状态
	 */
	ActionStatusBO actionStatus;

}
