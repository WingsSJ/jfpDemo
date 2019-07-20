package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChannelTechnicanMapper {
    int createOneChannelTechnicanRecord(@Param("channelTechnicanAddDTO") ChannelTechnicanAddDTO channelTechnicanAddDTO);
    List<ChannelTechnicanQueryDTO> queryCheckPendingTechnicans(Map params);
}
