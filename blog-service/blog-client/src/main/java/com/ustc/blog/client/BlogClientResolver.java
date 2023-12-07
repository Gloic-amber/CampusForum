package com.ustc.blog.client;

import com.ustc.blog.dto.BlogDTO;
import com.ustc.blog.dto.BlogGeneralDTO;
import com.ustc.common.result.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * BlogClient请求失败时的熔断处理类
 *
 * @author css
 */
@Slf4j
@Component
public class BlogClientResolver implements BlogClient {

    /**
     * 获取博客基本信息
     *
     * @param id 博客id
     * @return 博客信息
     */
    @Override
    public RestResult<BlogDTO> getBlogInfo(Integer id) {
        log.error("Blog 服务异常：getBlogInfo 请求失败");
        return RestResult.fail("request fail");
    }

    /**
     * 获取用户所发表的博客各项数据
     *
     * @param userIds 用户id
     * @return 用户发表博客数据统计
     */
    @Override
    public RestResult<List<BlogGeneralDTO>> getBlogUserGeneral(Integer[] userIds) {
        log.error("Blog 服务异常：getBlogUserGeneral 请求失败");
        return RestResult.fail("request fail");
    }

}