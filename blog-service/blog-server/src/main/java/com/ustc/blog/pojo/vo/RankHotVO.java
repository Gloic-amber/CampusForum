package com.ustc.blog.pojo.vo;

import com.ustc.blog.pojo.domain.Blog;
import com.ustc.user.dto.UserDTO;
import lombok.Data;

/**
 * @author css
 */
@Data
public class RankHotVO {

	/**
	 * 博客信息
	 */
	Blog blog;

	/**
	 * 用户信息
	 */
	UserDTO author;

	/**
	 * 排行榜热度
	 */
	Double hot;

}
