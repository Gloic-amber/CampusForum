package com.ustc.blog.content.service;

import com.ustc.blog.content.pojo.BlogListVO;
import com.ustc.blog.content.pojo.SearchQuery;

/**
 * @author css
 */
public interface BlogContentService {

    /**
     * 搜索博客
     *
     * @param searchQuery 搜索条件
     * @return 搜索到的结果
     */
    BlogListVO searchBlog(SearchQuery searchQuery);

}
