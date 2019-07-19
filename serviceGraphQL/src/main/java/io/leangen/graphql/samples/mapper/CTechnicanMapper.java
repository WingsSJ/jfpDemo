package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.dto.ChannelTechnican;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CTechnicanMapper {
    int createOneRecord(@Param("channelTechnican") ChannelTechnican channelTechnican);
}
