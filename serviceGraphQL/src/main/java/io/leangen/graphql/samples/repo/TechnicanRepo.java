package io.leangen.graphql.samples.repo;

import io.leangen.graphql.samples.dto.ChannelTechnican;
import io.leangen.graphql.samples.mapper.CTechnicanMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TechnicanRepo {
    @Resource
    CTechnicanMapper cTechnicanMapper;
    
    public int createOneRecord(ChannelTechnican channelTechnican){
        return cTechnicanMapper.createOneRecord(channelTechnican);
    }
}
