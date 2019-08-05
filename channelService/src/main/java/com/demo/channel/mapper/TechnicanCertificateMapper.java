package com.demo.channel.mapper;


import com.demo.common.module.DTO.TechnicanCertificateAddDTO;
import com.demo.common.module.DTO.TechnicanCertificateQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TechnicanCertificateMapper {
    int recordTechnicanCertificateRecords(@Param("technicanCertificateAddDTOList") List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList);
    List<TechnicanCertificateQueryDTO> findTechnicanCertificateByPersonIdList(@Param("personIdList") List<String> personIdList);
    List<TechnicanCertificateQueryDTO> findTechnicanCertificateByPersonId(@Param("personId") String personId);
    int updateTechnicanCertificateRecords(@Param("technicanCertificateAddDTOList") List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList);
}
