package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.DTO.CasAreaMapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CasAreaMapper {
    List<CasAreaMapDTO> queryAll();
}
