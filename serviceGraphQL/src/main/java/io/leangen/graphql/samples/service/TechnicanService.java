package io.leangen.graphql.samples.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.Utils.JsonObject;
import io.leangen.graphql.samples.model.DO.ChannelTechnicanExcelModelDO;
import io.leangen.graphql.samples.model.DTO.*;
import io.leangen.graphql.samples.model.VO.ChannelTechnicanVO;
import io.leangen.graphql.samples.model.VO.PageVO;
import io.leangen.graphql.samples.repo.ChannelTechnicanExcelRepo;
import io.leangen.graphql.samples.repo.ChannelTechnicanRepo;
import io.leangen.graphql.samples.repo.TechnicanCertificateRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.leangen.graphql.samples.model.VO.ChannelTechnicanVO.transToChannelTechnicanVO;
import static io.leangen.graphql.samples.model.VO.ChannelTechnicanVO.transToChannelTechnicanVOList;

/**
 * 渠道技术人员服务
 */
@GraphQLApi
@Service
public class TechnicanService {
    @Autowired
    private ChannelTechnicanRepo channelTechnicanRepo;
    @Autowired
    private TechnicanCertificateRepo technicanCertificateRepo;
    @Autowired
    private ChannelTechnicanExcelRepo channelTechnicanExcelRepo;

    @GraphQLMutation
    public JsonObject createOneChannelTechnicanRecord(@Valid ChannelTechnicanAddDTO channelTechnicanAddDTO){
        //是否存在未处理记录
        boolean haveRecord = channelTechnicanRepo.queryOneChannelTechnicanHaveRecord(channelTechnicanAddDTO);
        if(haveRecord){
            return new JsonObject(HttpStatus.BAD_REQUEST.value(),"this person have record");
        }
        boolean success = channelTechnicanRepo.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        if(success){
            return new JsonObject(HttpStatus.OK.value(),"add channelTechnican successful");
        }
        return new JsonObject(HttpStatus.BAD_REQUEST.value(),"add channelTechnican fail");
    }

    /****** 查询接口 ******/
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryCheckPendingTechnicans(@GraphQLNonNull int pageSize, @GraphQLNonNull int pageNum,String companyName,String personName){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryCheckPendingTechnicans(pageSize, pageNum,companyName,personName);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOList.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOList, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.queryCheckPendingTechnicansTotal(companyName,personName);
        }
        return new PageVO(pageNum,pageSize,totalNum,channelTechnicanVOList);
    }

    //TODO 渠道技术人员查询 （通过或者不通过的人员） 3
    @GraphQLQuery
    public PageVO<ChannelTechnicanVO> queryHaveCheckTechnicans(@GraphQLNonNull int pageSize, @GraphQLNonNull int pageNum,String companyName,String personName){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryHaveCheckTechnicans(pageSize, pageNum,companyName,personName);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOList.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOList, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.queryHaveCheckTechnicansTotal(companyName,personName);
        }
        return new PageVO(pageNum,pageSize,totalNum,channelTechnicanVOList);
    }


    //TODO 渠道技术人员管理页面 预览操作
    @GraphQLQuery
    public ChannelTechnicanVO previewTechnicanInfo(@GraphQLNonNull String personId){
        ChannelTechnicanQueryDTO channelTechnicanQueryDTO = channelTechnicanRepo.previewTechnicanInfo(personId);
        ChannelTechnicanVO channelTechnicanVO = new ChannelTechnicanVO();
        if(channelTechnicanQueryDTO != null) {
            List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonId(personId);
            //重新组装为VO
            channelTechnicanVO = transToChannelTechnicanVO(channelTechnicanQueryDTO, technicanCertificateQueryDTOList);
            channelTechnicanVO.setMessage("query success");
            channelTechnicanVO.setResult(0);
            return channelTechnicanVO;
        }else {
            channelTechnicanVO.setMessage("check param personId");
            channelTechnicanVO.setResult(1);
            return channelTechnicanVO;
        }
    }


    /****** 修改接口 ******/
    //TODO  1审核通过 2审核不通过
    @GraphQLMutation
    public JsonObject reviewOperation(@GraphQLNonNull String personId , @GraphQLNonNull int review, String notPassCause){
        //如果审核不通过要说明不通过的原因
        if(2 == review){
            if(StringUtils.isBlank(notPassCause)){
                return new JsonObject(1,"check param notPassCause is necessary");
            }
        }
        if(1 == review || 2 == review){
            boolean operate = channelTechnicanRepo.reviewOperation(personId,review,notPassCause);
            if(operate){
                return new JsonObject(0,"operate success");
            }else {
                return new JsonObject(1,"check param personId:"+personId+" review:"+review);
            }
        }else {
            return new JsonObject(1,"check param review: "+ review);
        }
    }

    //TODO 渠道技术人员管理页面 修改操作 （可以修改人员信息 或者给技术人员添加认证信息 并且该条状态重新进入待审核状态）
    @GraphQLMutation
    public JsonObject updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
        boolean operate = channelTechnicanRepo.updateTechnicanInfo(channelTechnicanUpdateDTO);
        if(operate){
            return new JsonObject(0,"update success");
        }else {
            return new JsonObject(1,"check param: "+ JSON.toJSONString(channelTechnicanUpdateDTO));
        }
    }

    //TODO 测试 （删除人员信息和相关证书信息）
    @GraphQLMutation
    public JsonObject deleteTechnican(@GraphQLNonNull String personId){
        boolean operate = channelTechnicanRepo.deleteTechnican(personId);
        if(operate){
            return new JsonObject(0,"delete success");
        }else {
            return new JsonObject(1,"check param: "+ personId);
        }
    }


    //TODO 数据校验 数据入库
    @GraphQLMutation
    public JsonObject batchImportTechnicans(String fileUrl){
        if(StringUtils.isNotBlank(fileUrl)){
            ImportParams importParams = new ImportParams();
            importParams.setTitleRows(0);
            importParams.setHeadRows(2);
            List<ChannelTechnicanExcelModelDO> list = ExcelImportUtil.importExcel(new File(fileUrl),
                    ChannelTechnicanExcelModelDO.class,importParams);
            if(CollectionUtils.isNotEmpty(list)){
                //TODO 数据校验 数据存入数据库
                for(ChannelTechnicanExcelModelDO channelTechnicanExcelModelDO:list){
                    if(channelTechnicanExcelModelDO.checkNull()){
                        channelTechnicanExcelModelDO.setVerifyResult("数据不完整 personName:"+ channelTechnicanExcelModelDO.getPersonName());
//                        channelTechnicanExcelRepo.batchImportTechnicans()
                    }else {
                        channelTechnicanExcelModelDO.setVerifyResult("数据校验通过");
                    }
                }
            }
        }
        return null;
    }

    //TODO excel数据查询操作


    //TODO excel数据删除操作
}
