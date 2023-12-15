package com.ustc.resource.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ustc.common.result.RestResult;
import com.ustc.common.web.utils.ResponseUtils;
import com.ustc.resource.config.ResourcePath;
import com.ustc.resource.mapper.ImageMapper;
import com.ustc.resource.pojo.Image;
import com.ustc.resource.service.ImageService;
import com.ustc.resource.service.MinioService;
import io.minio.errors.MinioException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

/**
 * ClassName: ImageServiceImpl
 * Package: com.ustc.resource.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Resource
    private MinioService minioService;

    @Resource
    private ImageMapper imageMapper;

    @Override
    public void getAvatarImage(String file, HttpServletResponse response) {
        getImage(file, "avatar", response);
    }

    @Override
    public void getGeneralImage(String file, HttpServletResponse response) {
        boolean image = getImage(file, "image", response);
        // 访问成功的话，图片访问量加1
        if (image) {
            imageMapper.increaseVisit(file);
        }
    }

    @SneakyThrows(value = IOException.class)
    private boolean getImage(String file, String bucketName, @Valid @NotNull HttpServletResponse response) {
        log.debug("getImg, fileName->{}, bucketName->{}", file, bucketName);
        try {
            minioService.download(file, bucketName, response);
            response.setContentType("image/jpeg");
            return true;
        } catch (MinioException | IOException e) {
            try {
                ResponseUtils.objectToJson(response, new RestResult<>(404, "资源不存在"));
            } catch (IllegalStateException ignored) {
                // 忽略连接状态异常引起的报错，由用户多次重复刷新引起
            }
        }
        return false;
    }

    @Override
    public String uploadAvatar(MultipartFile image, String name) {
        try {
            return uploadImage(image, "avatar");
        } catch (IOException | MinioException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String uploadBlogImage(MultipartFile image) throws MinioException, IOException {
        return uploadImage(image, "image");
    }

    private String uploadImage(MultipartFile image, String bucketName) throws IOException, MinioException {
        try (InputStream stream = image.getInputStream()) {
            String md5 = DigestUtils.md5DigestAsHex(stream);
            // 存数据库，上传图片
            // 先判断数据库是否存在这条记录，存在的话直接返回链接就行了
            LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Image::getUrl, md5);
            if (!imageMapper.exists(wrapper)) {
                // 不存在，则新增
                Image img = new Image();
                img.setUrl(md5);
                img.setCreateTime(new Timestamp(System.currentTimeMillis()));
                imageMapper.insert(img);
                // 上传图片
                minioService.upload(image, md5, bucketName);
            }
            // 返回访问链接
            return ResourcePath.imageUrlBase + md5;
        }
    }

}
