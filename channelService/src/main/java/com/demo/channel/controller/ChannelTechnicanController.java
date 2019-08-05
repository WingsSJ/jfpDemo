package com.demo.channel.controller;

import com.demo.channel.model.VO.ChannelTechnicanVO;
import com.demo.channel.service.ChannelTechnicanService;
import com.demo.common.module.DO.ChannelTechnicanExcelModelDO;
import com.demo.common.module.DTO.*;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/channel")
@Slf4j
public class ChannelTechnicanController {
    private final ChannelTechnicanService channelTechnicanService;
    @Autowired
    ChannelTechnicanController(ChannelTechnicanService channelTechnicanService) {
        this.channelTechnicanService = channelTechnicanService;
    }
    //TODO
    // 5.测试接口 注意有的语句需要添加时间为最近一条的条件语句

    /**
     * @author Wings
     * @apiNote 渠道技术人员录入
     */
    @PostMapping("/import/technican")
    public JsonObject importTechnican(@Valid @RequestBody ChannelTechnicanAddDTO channelTechnicanAddDTO){
        return channelTechnicanService.importTechnican(channelTechnicanAddDTO);
    }

    /**
     * @author Wings
     * @apiNote 查询所有待审核技术人员 支持按照公司名和人员名模糊查询
     */
    @PostMapping("query/all/technicans")
    public PageVO<ChannelTechnicanVO> queryAllTechnicans(@Valid @RequestBody ChannelTechnicanListQueryDTO channelTechnicanListQueryDTO){
        return channelTechnicanService.queryAllTechnicans(
                channelTechnicanListQueryDTO.getPageSize(),
                channelTechnicanListQueryDTO.getPageNum(),
                channelTechnicanListQueryDTO.getCompanyName(),
                channelTechnicanListQueryDTO.getPersonName(),
                channelTechnicanListQueryDTO.getReviewStatus()
        );
    }

    /**
     * @author Wings
     * @apiNote 预览技术人员详情
     */
    @RequestMapping("/preview/technican/info/{personId}")
    public ChannelTechnicanVO previewTechnicanInfo(@PathVariable("personId") String personId){
        return channelTechnicanService.previewTechnicanInfo(personId);
    }

    /**
     *@author Wings
     *@apiNote 未审核渠道技术人员审批
     */
    @PostMapping("/review/technican")
    public JsonObject reviewOperation(@Valid @RequestBody ChannelTechnicanCheckDTO channelTechnicanCheckDTO){
        return channelTechnicanService.reviewOperation(
                channelTechnicanCheckDTO.getPersonId(),
                channelTechnicanCheckDTO.getReview(),
                channelTechnicanCheckDTO.getNotPassCause()
        );
    }

    /**
     *@author Wings
     *@apiNote 修改操作（可以修改人员信息 或者给技术人员添加认证信息 并且该条状态重新进入待审核状态）
     * // TODO 只能做修改操作
     */
    @PostMapping("/update/technican")
    public JsonObject updateTechnicanInfo(@RequestBody ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
       return channelTechnicanService.updateTechnicanInfo(channelTechnicanUpdateDTO);
    }

    /**
     *@author Wings
     *@apiNote 删除人员信息和相关证书信息
     */
    @RequestMapping("/delete/technican/{personId}")
    public JsonObject deleteTechnican(@PathVariable("personId") String personId){
        return channelTechnicanService.deleteTechnican(personId);
    }

    /**
     * @author Wings
     * @apiNote 批量校验导入excel文件数据
     */
    @PostMapping("/batch/check")
    public List<ChannelTechnicanExcelModelDO> batchCheckTechnicans(@Valid @RequestBody ChannelTechnicanBatchCheckDTO channelTechnicanBatchCheckDTO){
        return channelTechnicanService.batchCheckTechnicans(
                channelTechnicanBatchCheckDTO.getFile(),
                channelTechnicanBatchCheckDTO.getCompanyName(),
                channelTechnicanBatchCheckDTO.getCompanyId()
        );
    }

    /**
     * @author Wings
     * @apiNote excel数据批量录入 //TODO
     */
    @PostMapping("batch/insert")
    public JsonObject batchInsertTechnicans(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS){
        return channelTechnicanService.batchInsertTechnicans(channelTechnicanExcelModelDOS);
    }

    /**
     * @author Wings
     * @apiNote APP 后台使用 根据搜索条件模糊查询渠道技术人员列表
     */
    @PostMapping("condition/query/technicans")
    public JsonObject<PageVO<ChannelTechnicanVO>> conditionQueryTechnicans(@Valid @RequestBody ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO){
        PageVO<ChannelTechnicanVO> channelTechnicanVOPageVO = channelTechnicanService.conditionQueryTechnicans(channelTechnicanListQueryByConditionDTO);
        return new JsonObject(0,"query success",channelTechnicanVOPageVO);
    }
}
