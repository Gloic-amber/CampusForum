package com.ustc.blog.pojo.vo;

import com.ustc.user.dto.UserDTO;
import lombok.Data;

/**
 * @author css
 */
@Data
public class RankAuthorVO {

	/**
	 * 用户信息
	 */
	UserDTO author;

	/**
	 * 排行榜热度
	 */
	Double hot;

	/**
	 * 粉丝数
	 */
	Integer fansNum;

	/**
	 * 获赞数
	 */
	Integer likeNum;

}
