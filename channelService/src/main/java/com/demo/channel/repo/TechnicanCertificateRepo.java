package com.demo.channel.repo;

import com.demo.channel.mapper.TechnicanCertificateMapper;
import com.demo.channel.model.DTO.TechnicanCertificateQueryDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TechnicanCertificateRepo {
    @Resource
    TechnicanCertificateMapper technicanCertificateMapper;

    public List<TechnicanCertificateQueryDTO> findTechnicanCertificateByPersonIdList(List<String> personIdList){
        List<TechnicanCertificateQueryDTO> technicanCertificateByPersonIdList = technicanCertificateMapper.findTechnicanCertificateByPersonIdList(personIdList);
        return technicanCertificateByPersonIdList;
    }

    public List<TechnicanCertificateQueryDTO> findTechnicanCertificateByPersonId(String personId){
        return technicanCertificateMapper.findTechnicanCertificateByPersonId(personId);
    }
}
