package io.leangen.graphql.samples.repo;

import io.leangen.graphql.samples.mapper.ChannelTechnicanExcelMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ChannelTechnicanExcelRepo {
    @Resource
    ChannelTechnicanExcelMapper channelTechnicanExcelMapper;
}
