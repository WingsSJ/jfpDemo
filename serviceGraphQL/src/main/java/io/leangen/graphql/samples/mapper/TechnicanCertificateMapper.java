package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.DTO.TechnicanCertificateAddDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnicanCertificateMapper {
    int recordTechnicanCertificateRecords(@Param("technicanCertificateAddDTOList") List<TechnicanCertificateAddDTO> technicanCertificateAddDTOList);
}