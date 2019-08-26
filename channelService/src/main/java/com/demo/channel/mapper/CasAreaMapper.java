package com.demo.channel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.common.module.DTO.CasAreaMapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CasAreaMapper extends BaseMapper {
    List<CasAreaMapDTO> queryAll();
}
