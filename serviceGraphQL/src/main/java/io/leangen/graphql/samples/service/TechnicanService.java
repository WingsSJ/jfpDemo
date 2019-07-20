package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.samples.model.DTO.ChannelTechnicanAddDTO;
import io.leangen.graphql.samples.model.VO.HttpBaseVO;
import io.leangen.graphql.samples.repo.ChannelTechnicanRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * 渠道技术人员服务
 */
@GraphQLApi
@Service
public class TechnicanService {
    @Autowired
    private ChannelTechnicanRepo channelTechnicanRepo;

    @GraphQLMutation
    public HttpBaseVO createOneChannelTechnicanRecord(ChannelTechnicanAddDTO channelTechnicanAddDTO){
        boolean success = channelTechnicanRepo.createOneChannelTechnicanRecord(channelTechnicanAddDTO);
        if(success){
            return new HttpBaseVO(HttpStatus.OK.value(),"add channelTechnican successful");
        }
        return new HttpBaseVO(HttpStatus.BAD_REQUEST.value(),"add channelTechnican fail");
    }
}
