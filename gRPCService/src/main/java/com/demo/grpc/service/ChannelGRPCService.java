package com.demo.grpc.service;

import com.demo.common.module.DTO.ChannelTechnicanListQueryByConditionDTO;
import com.demo.common.module.VO.ChannelTechnicanVO;
import com.demo.common.module.VO.ChannelVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import com.demo.grpc.feginService.ChannelFeginService;
import com.topsec.mobiapi.proto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//TODO 自测
@GRpcService
@Slf4j
//@Component
public class ChannelGRPCService extends ChannelServiceGrpc.ChannelServiceImplBase {
    @Autowired
    ChannelFeginService channelFeginService;
    @Override
    public void queryAllChannelTechnicians(ChannelTechnicianInfoRequest request, StreamObserver<ChannelTechnicianInfoListResponse> responseObserver) {
        //获取请求
        log.info("getPageSize: {}", request.getPageSize());
        log.info("getCurrPage: {}", request.getCurrPage());
        log.info("getSearchCondition: {}", request.getSearchCondition());
        JsonObject<PageVO<ChannelTechnicanVO>> channelTechnicanVOPageVO = channelFeginService.conditionQueryTechnicans(new ChannelTechnicanListQueryByConditionDTO(
                request.getPageSize(),
                request.getCurrPage(),
                request.getSearchCondition()
        ));
        //
        if (channelTechnicanVOPageVO.getResult() != 0) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("查询人员信息失败!")
                    .asRuntimeException());
            return;
        }
        List<ChannelTechnicianInfo> channelTechnicianInfos = new ArrayList<>();
        channelTechnicanVOPageVO.getObjEntity().getList().forEach(dto ->
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
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        ChannelTechnicianEntity channelTechnicianEntity = ChannelTechnicianEntity.newBuilder().addAllList(channelTechnicianInfos).setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage).build();
        ChannelTechnicianInfoListResponse channelTechnicianInfoListResponse
                = ChannelTechnicianInfoListResponse.newBuilder().setObjEntity(channelTechnicianEntity).setMesssage("success").setResult(0).build();
        responseObserver.onNext(channelTechnicianInfoListResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void queryAllChannelCompanys(ChannelCompanyInfoRequest request, StreamObserver<ChannelCompanyInfoListResponse> responseObserver) {
        //TODO 条件分页查询所有渠道商
        log.info("getPageSize: {}", request.getPageSize());
        log.info("getCurrPage: {}", request.getCurrPage());
        log.info("getSearchCondition: {}", request.getSearchCondition());
        JsonObject<PageVO<ChannelVO>> channelCompanyPageVO = channelFeginService.conditionQueryCompanys(new ChannelTechnicanListQueryByConditionDTO(
                request.getPageSize(),
                request.getCurrPage(),
                request.getSearchCondition()
        ));
        //
        if (channelCompanyPageVO.getResult() != 0) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("查询渠道公司信息失败!")
                    .asRuntimeException());
            return;
        }
        List<ChannelCompanyInfo> channelCompanyInfos = new ArrayList<>();
        channelCompanyPageVO.getObjEntity().getList().forEach(dto ->
                channelCompanyInfos.add(
                        ChannelCompanyInfo.newBuilder().setCemail(dto.getCid()).
                                setCname(dto.getCname()).
                                setAddr(dto.getAddr()).
                                setCemail(dto.getCemail()).
                                setPostalCode(dto.getPostalCode()).
                                setFax(dto.getFax()).
                                setTelephone(dto.getTelephone()).
                                setProvince(dto.getProvince()).
                                setCity(dto.getCity()).
                                setCounty(dto.getCounty()).
                                setCstar(dto.getCscale()).
                                setIsSupplier(dto.getIsSupplier()).
                                setClevel(dto.getClevel()).
                                setCscale(dto.getCscale()).
                                setCscope(dto.getCscope()).
                                setMainBus(dto.getMainBus()).
                                setCurl(dto.getCurl()).
                                setCredCode(dto.getCredCode()).
                                setRegisteredCapital((dto.getRegisteredCapital().doubleValue())).
                                setRegisteredType(dto.getRegisteredType()).
                                setRegisteredDate(dto.getRegisteredDate()).
                                setLegalName(dto.getLegalName()).
                                setLegalSex(dto.getLegalSex()).
                                setCorpTax(dto.getCorpTax()).
                                setCbank(dto.getCbank()).
                                setCaccount(dto.getCaccount()).
                                setManagerName(dto.getManagerName()).
                                setManagerSex(dto.getManagerSex()).
                                setManagerEmail(dto.getManagerEmail()).
                                setTechName(dto.getTechName()).
                                setManagerSex(dto.getManagerSex()).
                                setTechName(dto.getTechName()).
                                setTechSex(dto.getTechSex()).
                                setTechPost(dto.getTechPost()).
                                setTelephone(dto.getTelephone()).
                                setTechPhone(dto.getTechPhone()).
                                setTechEmail(dto.getTechEmail()).
                                setBusName(dto.getBusName()).
                                setBusSex(dto.getBusSex()).
                                setBusPost(dto.getBusPost()).
                                setBusTelephone(dto.getBusTelephone()).
                                setBusPhone(dto.getBusPhone()).
                                setBusEmail(dto.getBusEmail()).
                                setNotPassCause(dto.getNotPassCause()).build()
                )
        );
        Integer currPage = channelCompanyPageVO.getObjEntity().getCurrPage();
        Integer totalCount = channelCompanyPageVO.getObjEntity().getTotalCount();
        Integer pageSize = channelCompanyPageVO.getObjEntity().getPageSize();
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        ChannelCompanyInfoEntity channelCompanyInfoEntity = ChannelCompanyInfoEntity.newBuilder().addAllList(channelCompanyInfos).setCurrPage(currPage).setPageSize(pageSize).setTotalCount(totalCount).setTotalPage(totalPage).build();
        ChannelCompanyInfoListResponse channelCompanyInfoListResponse
                = ChannelCompanyInfoListResponse.newBuilder().setObjEntity(channelCompanyInfoEntity).setMesssage("success").setResult(0).build();
        responseObserver.onNext(channelCompanyInfoListResponse);
        responseObserver.onCompleted();
    }
}
