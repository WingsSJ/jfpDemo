package com.demo.channel.repo;

import com.demo.channel.mapper.ChannelTechnicanMapper;
import com.demo.channel.mapper.TechnicanCertificateMapper;
import com.demo.channel.utils.CodeMapUtil;
import com.demo.common.module.DTO.ChannelTechnicanAddDTO;
import com.demo.common.module.DTO.ChannelTechnicanQueryDTO;
import com.demo.common.module.DTO.ChannelTechnicanUpdateDTO;
import com.demo.common.module.DTO.TechnicanCertificateAddDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ChannelTechnicanRepo {
    @Resource
    ChannelTechnicanMapper channelTechnicanMapper;
    @Resource
    TechnicanCertificateMapper technicanCertificateMapper;


    public boolean batchCheckTechnicans(List<String> identityCardList){
        if(CollectionUtils.isNotEmpty(identityCardList)){
            //如果大于0 代表有未处理的数据 操作失败
            return channelTechnicanMapper.batchCheckTechnicans(identityCardList) > 0;
        }else {
            return true;
        }
    }

    public boolean queryOneChannelTechnicanHaveRecord(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        String personId = channelTechnicanAddDTO.getIdentityCard();
        int queryOneChannelTechnicanHaveRecord = channelTechnicanMapper.queryOneChannelTechnicanHaveRecord(personId);
        return queryOneChannelTechnicanHaveRecord > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean createOneChannelTechnicanRecord(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        //需要自己生成人员Id
        channelTechnicanAddDTO.setPersonId(UUID.randomUUID().toString());
        //传参校验
        if(channelTechnicanAddDTO.checkNull()){
            return false;
        }
        //获取相应的地区编码
        Map<String,String> areaCodeByAreaName = CodeMapUtil.getAreaCodeByAreaName(channelTechnicanAddDTO.getProvince(), channelTechnicanAddDTO.getCity(), channelTechnicanAddDTO.getCounty());
        channelTechnicanAddDTO.setProvince(areaCodeByAreaName.get("province"));
        channelTechnicanAddDTO.setCity(areaCodeByAreaName.get("city"));
        channelTechnicanAddDTO.setCounty(areaCodeByAreaName.get("county"));
        //记录渠道技术人员信息
        int oneChannelTechnicanRecord = channelTechnicanMapper.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList = channelTechnicanAddDTO.getTechnicanCertificateAddDTOS();
        //如果有相关技术证书 录入
        if(CollectionUtils.isNotEmpty(technicanCertificateAddDTOList)){
            technicanCertificateAddDTOList.forEach(dto->dto.setPersonId(channelTechnicanAddDTO.getPersonId()));
            //传参校验
            boolean checkParam = technicanCertificateAddDTOList.stream().anyMatch(technicanCertificateAddDTO ->
                    technicanCertificateAddDTO.getCertificateDirection().isEmpty() |technicanCertificateAddDTO.getCertificateId().isEmpty()
                    | technicanCertificateAddDTO.getCertificateLevel().isEmpty()
                    | technicanCertificateAddDTO.getInvalidCertificateTime().isEmpty());
            if(checkParam){
                return false;
            }else{
                //做证书批量插入操作
                int recordTechnicanCertificateRecords = technicanCertificateMapper.recordTechnicanCertificateRecords(technicanCertificateAddDTOList);
                return recordTechnicanCertificateRecords > 0 && oneChannelTechnicanRecord > 0;
            }
        }else{
            return oneChannelTechnicanRecord > 0;
        }
    }

    public List<ChannelTechnicanQueryDTO> queryAllTechnicans(int pageSize, int pageNum, String companyName, String personName,Integer reviewStatus){
        Map<String, Object> params = new HashMap<>(2);
        Integer offSet = pageSize * pageNum <= 0 ? 0 : pageSize * pageNum;
        params.put("companyName", companyName);
        params.put("personName", personName);
        params.put("reviewStatus", reviewStatus);
        params.put("offSet", offSet);
        params.put("rows", pageSize);
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList = channelTechnicanMapper.queryAllTechnicans(params);
        return channelTechnicanQueryDTOList;
    }

    public List<ChannelTechnicanQueryDTO> conditionQueryTechnicans(int pageSize,int pageNum,String searchCondition){
        Map<String, Object> params = new HashMap<>(3);
        Integer offSet = pageSize * pageNum <= 0 ? 0 : pageSize * pageNum;
        params.put("offSet",offSet);
        params.put("rows",pageSize);
        params.put("searchCondition",searchCondition);
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList = channelTechnicanMapper.conditionQueryTechnicans(params);
        return channelTechnicanQueryDTOList;
    }

    public int conditionQueryTechnicansTotal(String searchCondition){
        Map<String, Object> params = new HashMap<>(1);
        params.put("searchCondition",searchCondition);
        int total = channelTechnicanMapper.conditionQueryTechnicansTotal(params);
        return total;
    }


    public ChannelTechnicanQueryDTO previewTechnicanInfo(String personId){
        return channelTechnicanMapper.previewTechnicanInfo(personId);
    }

    public int queryAllTechnicansTotal(String companyName,String personName,Integer reviewStatus){
        Map<String, Object> params = new HashMap<>(3);
        params.put("companyName", companyName);
        params.put("personName", personName);
        params.put("reviewStatus", reviewStatus);
        return channelTechnicanMapper.queryAllTechnicansTotal(params);
    }


    public boolean reviewOperation(String personId,Integer review,String notPassCause){
        Map<String, Object> params = new HashMap<>(3);
        params.put("personId", personId);
        params.put("review", review);
        params.put("notPassCause", notPassCause);
        return channelTechnicanMapper.reviewOperation(params)>0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateTechnicanInfo(ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO){
        int updateOperate = channelTechnicanMapper.updateTechnicanInfo(channelTechnicanUpdateDTO);
        if(updateOperate>0){
            List<TechnicanCertificateAddDTO> technicanCertificateAddDTOS = channelTechnicanUpdateDTO.getTechnicanCertificateAddDTOS();
            if(CollectionUtils.isNotEmpty(technicanCertificateAddDTOS)){
                technicanCertificateAddDTOS.forEach(dto->dto.setPersonId(channelTechnicanUpdateDTO.getPersonId()));
                //传参校验
                boolean checkParam = technicanCertificateAddDTOS.stream().anyMatch(technicanCertificateAddDTO ->
                        technicanCertificateAddDTO.getCertificateDirection().isEmpty() |technicanCertificateAddDTO.getCertificateId().isEmpty()
                                | technicanCertificateAddDTO.getCertificateLevel().isEmpty()
                                | technicanCertificateAddDTO.getInvalidCertificateTime().isEmpty());
                if(checkParam){
                    //自定义传参异常 回滚
                    throw new RuntimeException();
                }else {
                    int recordTechnicanCertificateRecords = technicanCertificateMapper.recordTechnicanCertificateRecords(technicanCertificateAddDTOS);
                    return recordTechnicanCertificateRecords>0;
                }
            }
            return true;
        }
        return false;
    }

    public boolean deleteTechnican(String personId){
        //更新相关人员和证书数据
        int deleteTechnican = channelTechnicanMapper.deleteTechnican(personId);
        return deleteTechnican>0;
    }

    /**
     * 批量插入人员表和证书表
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean batchInsertTechnicans(List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS){
        //批量插入人员
        int insertRecord = channelTechnicanMapper.batchInsertTechnicans(channelTechnicanAddDTOS);
        //批量插入证书
        for(ChannelTechnicanAddDTO channelTechnicanAddDTO:channelTechnicanAddDTOS){
            List<TechnicanCertificateAddDTO> technicanCertificateAddDTOS = channelTechnicanAddDTO.getTechnicanCertificateAddDTOS();
            if(CollectionUtils.isNotEmpty(technicanCertificateAddDTOS)){
                technicanCertificateMapper.recordTechnicanCertificateRecords(technicanCertificateAddDTOS);
            }
        }
        return insertRecord > 0;
    }
}
