package io.leangen.graphql.samples.repo;

import io.leangen.graphql.samples.mapper.ChannelTechnicanMapper;
import io.leangen.graphql.samples.mapper.TechnicanCertificateMapper;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanUpdateDTO;
import io.leangen.graphql.samples.model.DTO.TechnicanCertificateAddDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanQueryDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChannelTechnicanRepo {
    @Resource
    ChannelTechnicanMapper channelTechnicanMapper;
    @Resource
    TechnicanCertificateMapper technicanCertificateMapper;
    
    public boolean createOneChannelTechnicanRecord(ChannelTechnicanAddDTO channelTechnicanAddDTO){
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
                    | technicanCertificateAddDTO.getReceiveCertificateTime().isEmpty());
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

    public List<ChannelTechnicanQueryDTO> queryCheckPendingTechnicans(int pageSize, int pageNum,String companyName,String personName){
        Map<String, Object> params = new HashMap<>(2);
        Integer offSet = pageSize * pageNum <= 0 ? 0 : pageSize * pageNum;
        params.put("companyName", companyName);
        params.put("personName", personName);
        params.put("offSet", offSet);
        params.put("rows", pageSize);
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList = channelTechnicanMapper.queryCheckPendingTechnicans(params);
        return channelTechnicanQueryDTOList;
    }

    public List<ChannelTechnicanQueryDTO> queryHaveCheckTechnicans(int pageSize, int pageNum,String companyName,String personName){
        Map<String, Object> params = new HashMap<>(4);
        Integer offSet = pageSize * pageNum <= 0 ? 0 : pageSize * pageNum;
        params.put("companyName", companyName);
        params.put("personName", personName);
        params.put("offSet", offSet);
        params.put("rows", pageSize);
        List<ChannelTechnicanQueryDTO> channelTechnicanQueryDTOList = channelTechnicanMapper.queryHaveCheckTechnicans(params);
        return channelTechnicanQueryDTOList;
    }

    public ChannelTechnicanQueryDTO previewTechnicanInfo(String personId){
        return channelTechnicanMapper.previewTechnicanInfo(personId);
    }

    public int queryCheckPendingTechnicansTotal(String companyName,String personName){
        Map<String, Object> params = new HashMap<>(2);
        params.put("companyName", companyName);
        params.put("personName", personName);
        return channelTechnicanMapper.queryCheckPendingTechnicansTotal(params);
    }

    public int queryHaveCheckTechnicansTotal(String companyName,String personName){
        Map<String, Object> params = new HashMap<>(2);
        params.put("companyName", companyName);
        params.put("personName", personName);
        return channelTechnicanMapper.queryHaveCheckTechnicansTotal(params);
    }

    public boolean reviewOperation(String personId,Integer review){
        Map<String, Object> params = new HashMap<>(2);
        params.put("personId", personId);
        params.put("review", review);
        return channelTechnicanMapper.reviewOperation(params)>0;
    }

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
                                | technicanCertificateAddDTO.getReceiveCertificateTime().isEmpty());
                if(checkParam){
                    //TODO 自定义传参异常 回滚
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
}
