package com.demo.grpc.client;

import com.topsec.mobiapi.proto.ChannelServiceGrpc;
import com.topsec.mobiapi.proto.ChannelTechnicianInfoListResponse;
import com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChannelClient {
    private ChannelServiceGrpc.ChannelServiceBlockingStub channelServiceBlockingStub;


    public String queryAllChannelTechnicians(ChannelTechnicianInfoRequest request) {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 51900).usePlaintext().build();

        channelServiceBlockingStub =
                ChannelServiceGrpc.newBlockingStub(managedChannel);
        ChannelTechnicianInfoRequest channelTechnicianInfoRequest = ChannelTechnicianInfoRequest.newBuilder().setCurrPage(0)
                .setPageSize(10).setSearchCondition("c").build();
        log.info("client sending {}", channelTechnicianInfoRequest);

        ChannelTechnicianInfoListResponse channelTechnicianInfoListResponse = channelServiceBlockingStub.queryAllChannelTechnicians(channelTechnicianInfoRequest);
        log.info("client received {}", channelTechnicianInfoListResponse);

        return channelTechnicianInfoListResponse.getMesssage();
    }
}
