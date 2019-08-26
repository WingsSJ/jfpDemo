package com.demo.channel.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.demo.channel.repo.ChannelTechnicanRepo;
import com.demo.channel.repo.TechnicanCertificateRepo;
import com.demo.common.module.DO.ChannelTechnicanExcelModelDTO;
import com.demo.common.module.DTO.*;
import com.demo.channel.model.VO.ChannelTechnicanVO;
import com.demo.common.module.VO.JsonObject;
import com.demo.common.module.VO.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.demo.channel.model.VO.ChannelTechnicanVO.transToChannelTechnicanVO;
import static com.demo.channel.model.VO.ChannelTechnicanVO.transToChannelTechnicanVOList;


/**
 * 渠道技术人员服务 （所属模块渠道服务）
 * @author Wings
 */
@Service
@Slf4j
public class ChannelTechnicanService {
    @Autowired
    private ChannelTechnicanRepo channelTechnicanRepo;
    @Autowired
    private TechnicanCertificateRepo technicanCertificateRepo;

    /**
     * 创建一条技术人员记录 //TODO 数据库操作转移service
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public JsonObject importTechnican(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        //是否存在未处理记录 (排除已经删除的和审核未通过的)
        boolean haveRecord = channelTechnicanRepo.queryOneChannelTechnicanHaveRecord(channelTechnicanAddDTO);
        if(haveRecord){
            return new JsonObject(1,"this person have record");
        }
        boolean success = channelTechnicanRepo.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        if(success){
            return new JsonObject(0,"add channelTechnican successful");
        }
        return new JsonObject(1,"add channelTechnican fail");
    }

    /**
     * 查询所有待审核的技术人员
     */
    @Transactional(readOnly = true)
    public PageVO<ChannelTechnicanVO> queryAllTechnicans(int pageSize, int pageNum, String companyName, String personName, Integer reviewStatus){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList =  channelTechnicanRepo.queryAllTechnicans(pageSize, pageNum,companyName,personName,reviewStatus);
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOList)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOList.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOList, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.queryAllTechnicansTotal(companyName,personName,reviewStatus);
        }
        return new PageVO(pageNum,pageSize,totalNum,channelTechnicanVOList);
    }


    /**
     * 渠道技术人员管理页面 预览操作
     */
    @Transactional(readOnly = true)
    public ChannelTechnicanVO previewTechnicanInfo(String personId){
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
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public JsonObject reviewOperation(String personId ,int review, String notPassCause){
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
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
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
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public JsonObject deleteTechnican(String personId){
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
    @Transactional(readOnly = true)
    public JsonObject<List<ChannelTechnicanExcelModelDTO>> batchCheckTechnicans(MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){
        List<ChannelTechnicanExcelModelDTO> channelTechnicanExcelModelDTOS = new ArrayList<>();
        response.setHeader("Access-Control-Allow-Origin","*");
        JsonObject jsonObject = new JsonObject(-1,null);
        File toFile = null;
        try {
            if ( multipartFile != null) {
                String path = request.getServletContext().getRealPath("/") + System.currentTimeMillis() + multipartFile.getOriginalFilename();
                toFile = new File(path);
                multipartFile.transferTo(toFile);
                ImportParams importParams = new ImportParams();
                importParams.setTitleRows(0);
                importParams.setHeadRows(2);
                List<ChannelTechnicanExcelModelDTO> list = ExcelImportUtil.importExcel(toFile,
                        ChannelTechnicanExcelModelDTO.class, importParams);
                if (CollectionUtils.isNotEmpty(list)) {
                    //数据校验
                    for (ChannelTechnicanExcelModelDTO channelTechnicanExcelModelDTO : list) {
                        //存入公司名和公司id
                        if (channelTechnicanExcelModelDTO.checkNull()) {
                            channelTechnicanExcelModelDTO.setVerifyResult("数据校验不通过:"+ channelTechnicanExcelModelDTO.checkNullInfo());
                            channelTechnicanExcelModelDTO.setVerifyCode(1);
                        } else {
                            channelTechnicanExcelModelDTO.setVerifyResult("数据校验通过");
                            channelTechnicanExcelModelDTO.setVerifyCode(0);
                        }
                        channelTechnicanExcelModelDTOS.add(channelTechnicanExcelModelDTO);
                    }
                }
            }
            //填充personId
            channelTechnicanExcelModelDTOS.stream().distinct().forEach(dto->dto.setPersonId(UUID.randomUUID().toString()));
            jsonObject.setResult(0);
            jsonObject.setObjEntity(channelTechnicanExcelModelDTOS);
        }catch (Exception e){
            e.printStackTrace();
            log.error("解析技术服务商Excel出错",e);
            jsonObject.setMessage("EXCEL解析错误,请确认文件格式的正确性!");
        }finally {
            if(toFile != null){
                toFile.delete();
            }
        }
        return jsonObject;
    }


    /**
     * excel数据批量录入
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public JsonObject batchInsertTechnicans(List<ChannelTechnicanExcelModelDTO> channelTechnicanExcelModelDTOS, String companyName, String companyId){
        List<String> identityCardList = channelTechnicanExcelModelDTOS.stream().map(ChannelTechnicanExcelModelDTO::getIdentityCard).collect(Collectors.toList());
        int size = channelTechnicanExcelModelDTOS.stream().map(ChannelTechnicanExcelModelDTO::getIdentityCard).distinct().collect(Collectors.toList()).size();
        //数据中不允许有重复身份证id和未经过校验的数据
        if(channelTechnicanExcelModelDTOS.stream().anyMatch(dto->dto.getVerifyCode().equals(1))
        || identityCardList.size() != size){
            return new JsonObject(1,"params check fail there has same identityCard");
        }
        boolean b = channelTechnicanRepo.batchCheckTechnicans(identityCardList);
        if(b){
            return new JsonObject(1,"batchInsert failed have exist personId");
        }
        boolean batchInsert = false;
        if(CollectionUtils.isNotEmpty(channelTechnicanExcelModelDTOS)){
            //填充companyName companyId
            channelTechnicanExcelModelDTOS.stream().distinct().forEach(dto->dto.setCompanyName(companyName));
            channelTechnicanExcelModelDTOS.stream().distinct().forEach(dto->dto.setCompanyId(companyId));
            //将channelTechnicanExcelModelDOS 转化为 AddDTO
            List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS = ChannelTechnicanAddDTO.transExcelModelDTOStoAddDTOS(channelTechnicanExcelModelDTOS);
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

    /**
     * conditionQueryTechnicans 条件查询技术人员信息
     */
    @Transactional(readOnly = true)
    public PageVO<ChannelTechnicanVO> conditionQueryTechnicans(ChannelTechnicanListQueryByConditionDTO channelTechnicanListQueryByConditionDTO){
        List<ChannelTechnicanVO> channelTechnicanVOList = new ArrayList<>();
        int totalNum = 0;
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOS = channelTechnicanRepo.conditionQueryTechnicans(
                channelTechnicanListQueryByConditionDTO.getPageSize(),
                channelTechnicanListQueryByConditionDTO.getCurrPage(),
                channelTechnicanListQueryByConditionDTO.getSearchCondition()
        );
        if(CollectionUtils.isNotEmpty(channelTechnicanQueryDTOS)){
            //查询出所有的证书信息
            List<String> personIdList = channelTechnicanQueryDTOS.stream().map(ChannelTechnicanQueryDTO::getPersonId).collect(Collectors.toList());
            if(CollectionUtils.isNotEmpty(personIdList)){
                List<TechnicanCertificateQueryDTO> technicanCertificateQueryDTOList = technicanCertificateRepo.findTechnicanCertificateByPersonIdList(personIdList);
                //重新组装为VO
                channelTechnicanVOList = transToChannelTechnicanVOList(channelTechnicanQueryDTOS, technicanCertificateQueryDTOList);
            }
            //查询出所有记录
            totalNum = channelTechnicanRepo.conditionQueryTechnicansTotal(
                    channelTechnicanListQueryByConditionDTO.getSearchCondition());
        }
        return new PageVO(channelTechnicanListQueryByConditionDTO.getCurrPage(),
                channelTechnicanListQueryByConditionDTO.getPageSize(),
                totalNum,channelTechnicanVOList);
    }
}
