package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanQueryDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChannelTechnicanMapper {
    int queryOneChannelTechnicanHaveRecord(@Param("identityCard")String identityCard);
    int createOneChannelTechnicanRecord(@Param("channelTechnicanAddDTO") ChannelTechnicanAddDTO channelTechnicanAddDTO);
    List<ChannelTechnicanQueryDTO> queryCheckPendingTechnicans(Map params);
    List<ChannelTechnicanQueryDTO> queryHaveCheckTechnicans(Map params);
    int queryCheckPendingTechnicansTotal(Map map);
    int queryHaveCheckTechnicansTotal(Map map);
    int reviewOperation(Map params);
    ChannelTechnicanQueryDTO previewTechnicanInfo(@Param("personId")String personId);
    int updateTechnicanInfo(@Param("channelTechnicanAddDTO") ChannelTechnicanUpdateDTO channelTechnicanUpdateDTO);
    int deleteTechnican(@Param("personId")String personId);
}
