package com.ustc.blog.content.controller;

import com.ustc.blog.content.pojo.BlogListVO;
import com.ustc.blog.content.pojo.SearchQuery;
import com.ustc.blog.content.service.BlogContentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author css
 */
@RestController
@RequestMapping("/blog/content")
public class BlogContentController {

    @Resource
    private BlogContentService blogContentService;

    /**
     * 搜索博客
     *
     * @return 博客列表
     */
    @GetMapping("/search")
    public BlogListVO searchBlog(@Validated SearchQuery searchQuery) {
        return blogContentService.searchBlog(searchQuery);
    }

}
