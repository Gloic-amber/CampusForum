package com.ustc.blog.mapper;

import com.ustc.blog.pojo.domain.Blog;
import com.ustc.blog.pojo.domain.BlogCount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author css
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 获取各状态下的博客数量
     *
     * @param authorId 作者id
     * @return 博客数量列表
     */
    @Select("select `status`,count(*) as number from blog where author_id = #{authorId} group by `status` order by status;")
    List<BlogCount> selectBlogCountListByAuthorId(@Param("authorId") int authorId);

}
