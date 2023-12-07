package com.ustc.blog.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author css
 */
@Data
public class BlogGeneral {

	/**
	 * 博客id
	 */
	@TableId
	Integer blogId;

	/**
	 * 浏览量
	 */
	Integer viewNum;

	/**
	 * 点赞量
	 */
	Integer likeNum;

	/**
	 * 评论量
	 */
	Integer commentNum;

	/**
	 * 收藏量
	 */
	Integer collectionNum;

	/**
	 * 评分
	 */
	Integer score;

	/**
	 * 是否已经删除，0未删除，1已删除
	 */
	Integer deleted;

}
