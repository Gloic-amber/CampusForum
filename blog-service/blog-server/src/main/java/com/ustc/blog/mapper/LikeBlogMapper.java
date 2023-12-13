package com.ustc.blog.mapper;

import com.ustc.blog.pojo.domain.LikeBlog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author css
 */
@Mapper
public interface LikeBlogMapper extends BaseMapper<LikeBlog> {

    /**
     * 获取用户对某列表博客的点赞状态
     *
     * @param userId     用户id
     * @param blogIdList 博客id列表
     * @return 在列表中点过赞的博客
     */
    @MapKey("value")
    Map<Integer, Integer> selectMapByUserIdAndBlogIdList(@Param("userId") Integer userId,@Param("blogIdList") Integer[] blogIdList);

}
