package com.ustc.blog.mapper;

import com.ustc.blog.pojo.domain.BlogGeneral;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author css
 */
@Mapper
public interface BlogGeneralMapper extends BaseMapper<BlogGeneral> {

    /**
     * 博客阅读量+1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set view_num = view_num + 1 where blog_id = #{blogId};")
    void increaseViewNum(@Param("blogId") Integer blogId);

    /**
     * 博客点赞数+1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set like_num = like_num + 1 where blog_id = #{blogId};")
    void increaseLikeNum(@Param("blogId") Integer blogId);

    /**
     * 博客点赞数-1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set like_num = like_num - 1 where blog_id = #{blogId} and like_num > 0;")
    void decreaseLikeNum(@Param("blogId") Integer blogId);

    /**
     * 博客收藏数+1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set collection_num = collection_num + 1 where blog_id = #{blogId};")
    void increaseCollectionNum(@Param("blogId") Integer blogId);

    /**
     * 博客收藏数-1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set collection_num = collection_num - 1 where blog_id = #{blogId} and collection_num > 0;")
    void decreaseCollectionNum(@Param("blogId") Integer blogId);

    /**
     * 博客评论数+1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set comment_num = comment_num + 1 where blog_id = #{blogId};")
    void increaseCommentNum(@Param("blogId") Integer blogId);

    /**
     * 博客评论数-1
     *
     * @param blogId 博客id
     */
    @Update("update blog_general set comment_num = comment_num - 1 where blog_id = #{blogId} and comment_num > 0;")
    void decreaseCommentNum(@Param("blogId") Integer blogId);

}
