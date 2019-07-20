package io.leangen.graphql.samples.repo;

import io.leangen.graphql.samples.mapper.ChannelTechnicanMapper;
import io.leangen.graphql.samples.mapper.TechnicanCertificateMapper;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.DTO.TechnicanCertificateAddDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
}
