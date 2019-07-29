package io.leangen.graphql.samples.service;

import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import com.demo.common.module.DTO.*;
import com.demo.common.module.VO.PageVO;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.feginService.ChannelFeginService;
import io.leangen.graphql.samples.model.ChannelTechnicanVO;
import io.leangen.graphql.samples.utils.JsonObject;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 渠道技术人员服务 （所属模块渠道服务）
 * @author Wings
 */
@GraphQLApi
@Service
public class TechnicanService {
    @Autowired
    private ChannelFeginService channelFeginService;

    /**
     * 创建一条技术人员记录 //TODO 数据库操作转移service
     */
    @GraphQLMutation
    public JsonObject importTechnican(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        //是否存在未处理记录
        return channelFeginService.importTechnican(channelTechnicanAddDTO);
    }

    /**
     * 查询所有待审核的技术人员
     */
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryCheckPendingTechnicans(ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO){
        return channelFeginService.queryCheckPendingTechnicans(channelTechnicanListQueryDTO);
    }


    /**
     *渠道技术人员查询 （通过或者不通过的人员）
     */
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryHaveCheckTechnicans(ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO){
        return channelFeginService.queryHaveCheckTechnicans(channelTechnicanListQueryDTO);
    }


    /**
     * 渠道技术人员管理页面 预览操作
     */
    @GraphQLQuery
    public ChannelTechnicanVO previewTechnicanInfo(@GraphQLNonNull String personId){
        return channelFeginService.previewTechnicanInfo(personId);
    }


    /**
     *审核接口 0待审核 1审核通过 2审核不通过
     */
    @GraphQLMutation
    public JsonObject reviewOperation(ChannelTechnicanCheckDTO channelTechnicanCheckDTO){
        //如果审核不通过要说明不通过的原因
        return channelFeginService.reviewOperation(channelTechnicanCheckDTO);
    }

    /**
     * 修改操作（可以修改人员信息 或者给技术人员添加认证信息 并且该条状态重新进入待审核状态）
     */
    @GraphQLMutation
    public JsonObject updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
        return channelFeginService.updateTechnicanInfo(channelTechnicanUpdateDTO);
    }

    /**
     * 删除人员信息和相关证书信息
     */
    @GraphQLMutation
    public JsonObject deleteTechnican(@GraphQLNonNull String personId){
        return channelFeginService.deleteTechnican(personId);
    }


    /**
     * 导入数据校验
     */
    @GraphQLMutation
    public PageVO<ChannelTechnicanExcelModelDO> batchCheckTechnicans(ChannelTechnicanBatchCheckDTO channelTechnicanBatchCheckDTO){
        return channelFeginService.batchCheckTechnicans(channelTechnicanBatchCheckDTO);
    }


    /**
     * excel数据批量录入 //TODO 服务测试
     */
    @GraphQLMutation
    public JsonObject batchInsertTechnicans(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS){
        return channelFeginService.batchInsertTechnicans(channelTechnicanExcelModelDOS);
    }
}
