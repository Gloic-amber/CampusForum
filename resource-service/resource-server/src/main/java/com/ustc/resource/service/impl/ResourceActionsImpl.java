package com.ustc.resource.service.impl;

import com.ustc.common.grpc.*;
import com.ustc.resource.service.ImageService;
import com.ustc.resource.service.UniversityService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ResourceActionsImpl
 * Package: com.ustc.resource.service.impl
 * Description: grpc的服务端
 *
 * @Author Gloic
 * @Create 2023/12/19
 * @Version 1.0
 */

@GrpcService
public class ResourceActionsImpl extends ResourceActionsGrpc.ResourceActionsImplBase {

    @Resource
    private UniversityService universityService;

    @Resource
    private ImageService imageService;

    // 获得大学名称
    @Override
    public void getUniversityName(SchoolCode request, StreamObserver<University> responseObserver){
        String universityName = universityService.getUniversityName(request.getCode());
        responseObserver.onNext(University.newBuilder().setName(universityName).build());
        responseObserver.onCompleted();
    }

    // 上传头像
    @Override
    public void uploadAvatarImage(AvatarImage request, StreamObserver<ImageUrl> responseObserver){
        // 将request中的字节数组转化为MultipartFile文件
        InputStream inputStream = new ByteArrayInputStream(request.getImage().toByteArray());
        MultipartFile image = null;
        try {
            image = new MockMultipartFile(request.getName(), request.getName(), request.getContentType(), inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 调用图片服务进行上传
        String url = imageService.uploadAvatar(image, request.getName());
        // 传回URL参数
        responseObserver.onNext(ImageUrl.newBuilder().setUrl(url).build());
        responseObserver.onCompleted();
    }
}
