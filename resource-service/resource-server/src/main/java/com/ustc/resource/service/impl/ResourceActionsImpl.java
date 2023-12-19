package com.ustc.resource.service.impl;

import com.ustc.common.grpc.ResourceActionsGrpc;
import com.ustc.common.grpc.SchoolCode;
import com.ustc.common.grpc.University;
import com.ustc.resource.service.UniversityService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

/**
 * ClassName: ResourceActionsImpl
 * Package: com.ustc.resource.service.impl
 * Description:
 *
 * @Author Gloic
 * @Create 2023/12/19
 * @Version 1.0
 */

@GrpcService
public class ResourceActionsImpl extends ResourceActionsGrpc.ResourceActionsImplBase {

    @Resource
    private UniversityService universityService;

    @Override
    public void getUniversityName(SchoolCode request, StreamObserver<University> responseObserver){
        String universityName = universityService.getUniversityName(request.getCode());
        responseObserver.onNext(University.newBuilder().setName(universityName).build());
        responseObserver.onCompleted();
    }
}
