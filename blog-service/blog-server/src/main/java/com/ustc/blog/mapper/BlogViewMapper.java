package com.ustc.blog.mapper;

import com.ustc.blog.pojo.domain.BlogUserGeneral;
import com.ustc.blog.pojo.domain.BlogView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author css
 */
@Mapper
public interface BlogViewMapper extends BaseMapper<BlogView> {

    /**
     * 查询用户发送的博客各项数据的统计
     *
     * @param userIds 用户id集合
     * @return 统计数据
     */
    List<BlogUserGeneral> selectBlogViewsByUserIds(Integer[] userIds);

}