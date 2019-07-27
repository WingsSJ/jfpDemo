package io.leangen.graphql.samples.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.utils.JsonObject;
import io.leangen.graphql.samples.model.DO.ChannelTechnicanExcelModelDO;
import io.leangen.graphql.samples.model.DTO.*;
import io.leangen.graphql.samples.model.VO.ChannelTechnicanVO;
import io.leangen.graphql.samples.model.VO.PageVO;
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

import static io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO.transExcelModelDTOStoAddDTOS;
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

    /**
     * 创建一条技术人员记录
     */
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

    /**
     * 查询所有待审核的技术人员
     */
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


    /**
     *渠道技术人员查询 （通过或者不通过的人员）
     */
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


    /**
     * 渠道技术人员管理页面 预览操作
     */
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


    /**
     *审核接口 0待审核 1审核通过 2审核不通过
     */
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

    /**
     * 修改操作（可以修改人员信息 或者给技术人员添加认证信息 并且该条状态重新进入待审核状态）
     */
    @GraphQLMutation
    public JsonObject updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
        boolean operate = channelTechnicanRepo.updateTechnicanInfo(channelTechnicanUpdateDTO);
        if(operate){
            return new JsonObject(0,"update success");
        }else {
            return new JsonObject(1,"check param: "+ JSON.toJSONString(channelTechnicanUpdateDTO));
        }
    }

    /**
     * 删除人员信息和相关证书信息
     */
    @GraphQLMutation
    public JsonObject deleteTechnican(@GraphQLNonNull String personId){
        boolean operate = channelTechnicanRepo.deleteTechnican(personId);
        if(operate){
            return new JsonObject(0,"delete success");
        }else {
            return new JsonObject(1,"check param: "+ personId);
        }
    }


    /**
     * 导入数据校验
     */
    @GraphQLMutation
    public PageVO<ChannelTechnicanExcelModelDO> batchCheckTechnicans(String fileUrl,String companyName,String companyId){
        List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS = new ArrayList<>();
        if(StringUtils.isNoneBlank(fileUrl,companyName,companyId)){
            ImportParams importParams = new ImportParams();
            importParams.setTitleRows(0);
            importParams.setHeadRows(2);
            List<ChannelTechnicanExcelModelDO> list = ExcelImportUtil.importExcel(new File(fileUrl),
                    ChannelTechnicanExcelModelDO.class,importParams);
            if(CollectionUtils.isNotEmpty(list)){
                //数据校验
                for(ChannelTechnicanExcelModelDO channelTechnicanExcelModelDO:list){
                    //存入公司名和公司id
                    channelTechnicanExcelModelDO.setCompanyId(companyId);
                    channelTechnicanExcelModelDO.setCompanyName(companyName);
                    if(channelTechnicanExcelModelDO.checkNull()){
                        channelTechnicanExcelModelDO.setVerifyResult("数据校验不通过");
                        channelTechnicanExcelModelDO.setVerifyCode(1);
                    }else {
                        channelTechnicanExcelModelDO.setVerifyResult("数据校验通过");
                        channelTechnicanExcelModelDO.setVerifyCode(0);
                    }
                }
            }
        }
        return new PageVO(0,channelTechnicanExcelModelDOS.size(),channelTechnicanExcelModelDOS.size(),channelTechnicanExcelModelDOS);
    }


    /**
     * excel数据批量录入 //TODO 服务测试
     */
    @GraphQLMutation
    public JsonObject batchInsertTechnicans(List<ChannelTechnicanExcelModelDO> channelTechnicanExcelModelDOS){
        boolean batchInsert = false;
        if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDOS)){
            //将channelTechnicanExcelModelDOS 转化为 AddDTO
            List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS = transExcelModelDTOStoAddDTOS(channelTechnicanExcelModelDOS);
            if(CollectionUtils.isNotEmpty(channelTechnicanAddDTOS)){
                //做批量插入操作
                batchInsert = channelTechnicanRepo.batchInsertTechnicans(channelTechnicanAddDTOS);
            }
        }
        if(batchInsert){
            return new JsonObject(0,"batchInsert success");
        }else {
            return new JsonObject(1,"batchInsert failed");
        }
    }
}
