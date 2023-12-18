package com.ustc.resource.controller;

/**
 * ClassName: UploadController
 * Package: com.ustc.resource.controller
 * Description:  图片上传
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

import com.ustc.resource.service.ImageService;
import com.ustc.resource.type.FileType;
import com.ustc.resource.utils.FileUtils;
import io.minio.errors.MinioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/private/resource")
@Validated
public class UploadController {

    @Resource
    private ImageService imageService;

    /**
     * 上传图片
     *
     * @param file 图片文件
     * @return 图片链接
     */
    @PostMapping("/image")
    public String uploadBlogImage(@NotNull MultipartFile file) throws MinioException, IOException {
        log.debug("uploadBlogImage, fileName->{}", file.getOriginalFilename());
        FileUtils.checkFile(file, 10 * 1024 * 1024L, FileType.JPEG, FileType.PNG);
        return imageService.uploadBlogImage(file);
    }

    /**
     * 上传头像
     *
     * @param file 头像文件
     * @return 图片链接
     */
    @PostMapping("/avatar")
    public String uploadAvatar(@NotNull MultipartFile file, @NotNull String name) {
        log.debug("uploadAvatar, fileName->{}", file.getOriginalFilename());
        log.info("上传了头像{}", name);
        FileUtils.checkFile(file, 10 * 1024 * 1024L, FileType.JPEG, FileType.PNG);
        return imageService.uploadAvatar(file, name);
    }

}
