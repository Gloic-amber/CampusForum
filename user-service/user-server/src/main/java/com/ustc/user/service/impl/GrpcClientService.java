package com.ustc.user.service.impl;

import com.google.protobuf.ByteString;
import com.ustc.common.grpc.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName: GrpcClientService
 * Package: com.ustc.user.service.impl
 * Description: grpc的客户端
 *
 * @Author Gloic
 * @Create 2023/12/19
 * @Version 1.0
 */

@Service
public class GrpcClientService {
    @GrpcClient("resource-server")
    ResourceActionsGrpc.ResourceActionsBlockingStub resourceActionsBlockingStub;

    // 获得大学名称
    public String getUniversityName(int schoolCode){
        University university = resourceActionsBlockingStub.getUniversityName(
                SchoolCode.newBuilder().setCode(schoolCode).build()
        );
        return university.getName();
    }

    // 上传头像
    public String uploadAvatarImage(MultipartFile file, String name){
        // 将MultipartFile转化为需要传输的ImageUrl类型后，调用远程服务
        ImageUrl imageUrl = null;
        try {
            imageUrl = resourceActionsBlockingStub.uploadAvatarImage(
                    AvatarImage.newBuilder()
                            .setImage(ByteString.copyFrom(file.getBytes()))
                            .setName(name)
                            .setContentType(file.getContentType())
                            .build()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageUrl.getUrl();
    }

}
