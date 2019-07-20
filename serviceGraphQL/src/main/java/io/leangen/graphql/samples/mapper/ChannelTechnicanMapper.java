package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChannelTechnicanMapper {
    int createOneChannelTechnicanRecord(@Param("channelTechnicanAddDTO") ChannelTechnicanAddDTO channelTechnicanAddDTO);
}
