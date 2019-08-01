package com.demo.grpc.service;

import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.grpc.feginService.ChannelFeginService;
import com.demo.grpc.model.ChannelTechnicanVO;
import com.topsec.mobiapi.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//TODO  自测
@GRpcService
public class ChannelGRPCService extends ChannelServiceGrpc.ChannelServiceImplBase{
    @Autowired
    ChannelFeginService channelFeginService;
    @Override
    public void queryAllChannelTechnicians(ChannelTechnicianInfoRequest request, StreamObserver<ChannelTechnicianInfoListResponse> responseObserver) {
        //获取请求
        JsonObject<PageVO<ChannelTechnicanVO>> channelTechnicanVOPageVO = channelFeginService.conditionQueryTechnicans(new ChannelTechnicanListQueryByConditionDTO(
                request.getPageContent().getPageSize(),
                request.getPageContent().getCurrPage(),
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
                ChannelTechnicianInfoListResponse.newBuilder().setCtInfo(index,channelTechnicianInfos.get(index));
            }
            ChannelTechnicianInfoListResponse channelTechnicianInfoListResponse
                    = ChannelTechnicianInfoListResponse.newBuilder().setPageContent(
                    BaseMessage.PageContent.newBuilder().setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage)).setBaseResponse(
                            BaseMessage.BaseResponse.newBuilder().setResult(0).setMesssage("success")).build();
        responseObserver.onNext(channelTechnicianInfoListResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void queryAllChannelCompanys(ChannelCompanyInfoRequest request, StreamObserver<ChannelCompanyInfoListResponse> responseObserver) {
        //TODO 查询所有渠道商
    }
}
