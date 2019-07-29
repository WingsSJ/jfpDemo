package com.demo.channel.mapper;

import com.demo.common.module.DTO.ChannelTechnicanAddDTO;
import com.demo.common.module.DTO.ChannelTechnicanQueryDTO;
import com.demo.common.module.DTO.ChannelTechnicanUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChannelTechnicanMapper {
    int queryOneChannelTechnicanHaveRecord(@Param("identityCard") String identityCard);
    int createOneChannelTechnicanRecord(@Param("channelTechnicanAddDTO") ChannelTechnicanAddDTO channelTechnicanAddDTO);
    List<ChannelTechnicanQueryDTO> queryCheckPendingTechnicans(Map params);
    List<ChannelTechnicanQueryDTO> queryHaveCheckTechnicans(Map params);
    int queryCheckPendingTechnicansTotal(Map map);
    int queryHaveCheckTechnicansTotal(Map map);
    int reviewOperation(Map params);
    ChannelTechnicanQueryDTO previewTechnicanInfo(@Param("personId") String personId);
    int updateTechnicanInfo(@Param("channelTechnicanUpdateDTO") ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO);
    int deleteTechnican(@Param("personId") String personId);
    int batchInsertTechnicans(@Param("channelTechnicanAddDTOS") List<ChannelTechnicanAddDTO> channelTechnicanAddDTOS);
    int batchCheckTechnicans(@Param("identityCardList") List<String> identityCardList);
}
