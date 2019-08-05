package com.demo.grpc.service;

import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.grpc.annotation.GrpcInterceptor;
import com.demo.grpc.feginService.ChannelFeginService;
import com.demo.grpc.interceptor.PtokenServerInterceptor;
import com.demo.grpc.model.ChannelTechnicanVO;
import com.topsec.mobiapi.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//TODO 自测
@GRpcService(interceptors = {PtokenServerInterceptor.class})
@Slf4j
public class ChannelGRPCService extends ChannelServiceGrpc.ChannelServiceImplBase{
    @Autowired
    ChannelFeginService channelFeginService;
    @Override
    public void queryAllChannelTechnicians(ChannelTechnicianInfoRequest request, StreamObserver<ChannelTechnicianInfoListResponse> responseObserver) {
        //获取请求
        JsonObject<PageVO<ChannelTechnicanVO>> channelTechnicanVOPageVO = channelFeginService.conditionQueryTechnicans(new ChannelTechnicanListQueryByConditionDTO(
                request.getPageSize(),
                request.getCurrPage(),
                request.getSearchCondition()
        ));
        //
        if(channelTechnicanVOPageVO.getResult() != 0){
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("查询人员信息失败!")
                    .asRuntimeException());
            return;
        }
            List<ChannelTechnicianInfo> channelTechnicianInfos = new ArrayList<>();
            channelTechnicanVOPageVO.getObjEntity().getList().forEach(dto->
                    channelTechnicianInfos.add(
                             ChannelTechnicianInfo.newBuilder().setCompanyId(dto.getCompanyId()).
                                     setCompanyName(dto.getCompanyName()).
                                     setPersonName(dto.getPersonName()).
                                     setPersonGender(dto.getPersonGender()).
                                     setPId(dto.getPersonId()).
                                     setIdCard(dto.getIdentityCard()).
                                     setBirthday(dto.getBirthday()).
                                     setPhone(dto.getPhone()).
                                     setProv(dto.getProvince()).
                                     setCity(dto.getCity()).
                                     setCounty(dto.getCounty()).
                                     setAddress(dto.getAddress()).
                                     setJob(dto.getJob()).
                                     setEmail(dto.getEmail()).
                                     setHireDate(dto.getHireDate()).
                                     setQqNum(dto.getQqNum()).
                                     setTelephone(dto.getTelephone()).
                                     setReStatues(dto.getReviewStatus()).build()
                    )
            );
            Integer currPage = channelTechnicanVOPageVO.getObjEntity().getCurrPage();
            Integer totalCount = channelTechnicanVOPageVO.getObjEntity().getTotalCount();
            Integer pageSize = channelTechnicanVOPageVO.getObjEntity().getPageSize();
            int totalPage = (int)Math.ceil((double)totalCount/pageSize);
            for(int index = 0; index < channelTechnicianInfos.size();index++) {
                ChannelTechnicianEntity.newBuilder().setList(index,channelTechnicianInfos.get(index));
            }
        ChannelTechnicianEntity channelTechnicianEntity = ChannelTechnicianEntity.newBuilder().setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage).build();
        ChannelTechnicianInfoListResponse channelTechnicianInfoListResponse
                    = ChannelTechnicianInfoListResponse.newBuilder().setObjEntity(channelTechnicianEntity).setMesssage("success").setResult(0).build();
        responseObserver.onNext(channelTechnicianInfoListResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void queryAllChannelCompanys(ChannelCompanyInfoRequest request, StreamObserver<ChannelCompanyInfoListResponse> responseObserver) {
        //TODO 查询所有渠道商
    }
}
