package com.ustc.blog.content.service;

import com.ustc.blog.content.pojo.BlogDTO;
import com.ustc.blog.content.pojo.BlogDoc;
import com.ustc.blog.content.pojo.BlogListVO;
import com.ustc.blog.content.pojo.SearchQuery;

import java.util.List;

/**
 * @author css
 */
public interface BlogContentService {

    /**
     * 搜索博客(在es中进行搜索
     *
     * @param searchQuery 搜索条件
     * @return 搜索到的结果
     */
    BlogListVO searchBlog(SearchQuery searchQuery);

    /**
     * 获得所有博客文档（用于导入到es中
     * @return 所有博客文档
     */
    List<BlogDTO> getBlogList();

}
