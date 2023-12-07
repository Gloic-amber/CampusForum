package com.ustc.blog.service;

import com.ustc.blog.pojo.vo.RankAuthorVO;
import com.ustc.blog.pojo.vo.RankHotVO;

import java.util.List;

/**
 * @author css
 */
public interface RankService {

	/**
	 * 获取当日博客热度排行榜
	 *
	 * @return 当日热度排行信息
	 */
	List<RankHotVO> getTodayHotRank();

	/**
	 * 获取周博客热度排行榜
	 *
	 * @return 上周热度排行信息
	 */
	List<RankHotVO> getWeekHotRank();

	/**
	 * 获取周作者排行榜
	 *
	 * @return 上周作者排行信息
	 */
	List<RankAuthorVO> getWeekAuthorRank();

	/**
	 * 获取作者总榜
	 *
	 * @return 作者总排行榜
	 */
	List<RankAuthorVO> getTotalAuthorRank();

	/**
	 * 获取作者排行榜数据
	 *
	 * @param key 查询的redis key
	 * @return 排行榜数据
	 */
	List<RankAuthorVO> getAuthorRank(String key);

	/**
	 * 修改博客热度分值
	 *
	 * @param blogId 修改热度的博客
	 * @param score  修改的分数
	 */
	void increaseRankHotScore(Integer blogId, Double score);

	/**
	 * 修改作者排行榜 原力值
	 * <p>
	 * todo 这里应该修改参数，blogId改为authorId更贴合该方法
	 *
	 * @param blogId 博客id
	 * @param score  修改的分数
	 */
	void increaseRankAuthorScore(Integer blogId, Double score);

}
