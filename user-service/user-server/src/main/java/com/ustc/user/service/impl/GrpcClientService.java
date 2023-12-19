package com.ustc.user.service.impl;

import com.ustc.common.grpc.ResourceActionsGrpc;
import com.ustc.common.grpc.SchoolCode;
import com.ustc.common.grpc.University;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * ClassName: GrpcClientService
 * Package: com.ustc.user.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/12/19
 * @Version 1.0
 */

@Service
public class GrpcClientService {
    @GrpcClient("resource-server")
    ResourceActionsGrpc.ResourceActionsBlockingStub resourceActionsBlockingStub;

    public String getUniversityName(int schoolCode){
        University university = resourceActionsBlockingStub.getUniversityName(
                SchoolCode.newBuilder().setCode(schoolCode).build()
        );
        return university.getName();
    }
}
