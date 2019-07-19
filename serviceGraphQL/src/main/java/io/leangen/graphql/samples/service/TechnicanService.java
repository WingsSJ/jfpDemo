package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.samples.dto.ChannelTechnican;
import io.leangen.graphql.samples.repo.TechnicanRepo;
import io.leangen.graphql.samples.reslt.HttpBase;
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
    private TechnicanRepo technicanRepo;

    @GraphQLMutation
    public HttpBase createOneRecord(ChannelTechnican channelTechnican){
        int oneRecord = technicanRepo.createOneRecord(channelTechnican);
        HttpBase httpBase = new HttpBase();
        if(oneRecord>1){
            httpBase.setCode(HttpStatus.OK.value());
            httpBase.setDescription("success create record");
            return httpBase;
        }
        httpBase.setCode(HttpStatus.BAD_REQUEST.value());
        httpBase.setDescription("fail create record");
        return httpBase;
    }
}
