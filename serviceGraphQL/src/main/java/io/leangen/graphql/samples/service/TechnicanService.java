package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanQueryDTO;
import io.leangen.graphql.samples.model.VO.ChannelTechnicanVO;
import io.leangen.graphql.samples.model.VO.HttpBaseVO;
import io.leangen.graphql.samples.model.VO.PageVO;
import io.leangen.graphql.samples.repo.ChannelTechnicanRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 渠道技术人员服务
 */
@GraphQLApi
@Service
public class TechnicanService {
    @Autowired
    private ChannelTechnicanRepo channelTechnicanRepo;

    //TODO 还未做接口测试
    @GraphQLMutation
    public HttpBaseVO createOneChannelTechnicanRecord(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        boolean success = channelTechnicanRepo.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        if(success){
            return new HttpBaseVO(HttpStatus.OK.value(),"add channelTechnican successful");
        }
        return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"add channelTechnican fail");
    }
    /****** 查询接口 ******/
    //TODO 渠道技术人员查询 （待审核的人员） 1
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryCheckPendingTechnicans(int pageSize, int pageNum){
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryCheckPendingTechnicans(pageSize, pageNum);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //
        }
        return null;
    }


    //TODO 渠道技术人员管理和待审核人员管理页面展示 （模糊查询 根据姓名和所在服务商）
    //TODO 渠道技术人员查询 （通过或者不通过的人员 ） 3
    //TODO 渠道技术人员管理页面 预览操作 （基本信息和认证信息展示 没有头像 账号 密码）

    /****** 修改接口 ******/
    //TODO 渠道技术人员管理页面 修改操作 （可以修改人员信息和证书信息 并且该条状态重新进入待审核状态）
    //TODO 渠道技术人员管理页面 和 待审核渠道技术人员列表页面 删除操作可以共用一个接口 （删除人员信息和相关证书信息）
    //TODO 待审核渠道技术人员列表页面 审核通过操作（状态改变为审核通过或者未通过） 2
}
