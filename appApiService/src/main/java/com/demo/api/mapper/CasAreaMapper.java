package com.demo.api.mapper;

import com.demo.common.module.DTO.CasAreaMapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CasAreaMapper {
    List<CasAreaMapDTO> queryAll();
}
