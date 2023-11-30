package com.ustc.resource.controller;

import com.ustc.resource.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: DownloadController
 * Package: com.ustc.resource.controller
 * Description:  图片获取
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/resource")
public class DownloadController {

    @Resource
    private ImageService imageService;

    /**
     * 获取头像资源
     *
     * @param file     文件名
     * @param response 响应头
     */
    @GetMapping("/avatar/{file}")
    public void getAvatar(@PathVariable String file, HttpServletResponse response) {
        imageService.getAvatarImage(file, response);
    }

    /**
     * 获取普通图片资源，封面图和内容里面的图片都用这一个
     *
     * @param file 文件名
     */
    @GetMapping("/image/{file}")
    public void getImage(@PathVariable String file, HttpServletResponse response) {
        imageService.getGeneralImage(file, response);
    }

}
