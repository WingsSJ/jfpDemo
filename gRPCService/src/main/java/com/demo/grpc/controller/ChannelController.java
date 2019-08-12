package com.demo.grpc.controller;

import com.demo.grpc.client.ChannelClient;
import com.topsec.mobiapi.proto.ChannelTechnicianInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ChannelController {
    @Autowired
    private ChannelClient channelClient;
    @RequestMapping("/queryAll")
    public void testSayHello() {
        ChannelTechnicianInfoRequest channelTechnicianInfoRequest = ChannelTechnicianInfoRequest.newBuilder().build();
        System.out.println((channelClient.queryAllChannelTechnicians(channelTechnicianInfoRequest)));
    }
}
