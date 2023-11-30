package com.ustc.resource.client.fuse;

import com.ustc.common.result.RestResult;
import com.ustc.resource.client.ResourceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: ResourceClientFuse
 * Package: com.ustc.resource.client.fuse
 * Description: Resource-server连接失败时使用的熔断器
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Component
public class ResourceClientFuse implements ResourceClient {

    /**
     * 上传图片接口
     *
     * @param file 图片
     * @return 图片链接
     */
    @Override
    public RestResult<String> uploadBlogImage(MultipartFile file) {
        log.error("Resource 服务异常：uploadBlogImage 请求失败");
        return new RestResult<>(503, "fail");
    }

    /**
     * 上传头像接口
     *
     * @param file 头像图片文件
     * @param name 图片命名
     * @return 是否上传成功
     */
    @Override
    public RestResult<String> uploadAvatarImage(MultipartFile file, String name) {
        log.error("Resource 服务异常：uploadAvatarImage 请求失败");
        return new RestResult<>(503, "fail");
    }

    /**
     * 通过院校代码获取名称
     *
     * @param schoolCode 院校代码
     * @return 高校名称
     */
    @Override
    public RestResult<String> getUniversityName(Integer schoolCode) {
        log.error("Resource 服务异常：getUniversityName 请求失败");
        return new RestResult<>(503, "fail");
    }

}
