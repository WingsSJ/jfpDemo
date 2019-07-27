package com.demo.channel.controller;

import com.demo.channel.service.ChannelTechnicanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channel")
@Slf4j
public class ChannelTechnicanController {
    private final ChannelTechnicanService channelTechnicanService;
    @Autowired
    ChannelTechnicanController(ChannelTechnicanService channelTechnicanService) {
        this.channelTechnicanService = channelTechnicanService;
    }
    //TODO
    // 1.编写controller层
    // 2.在graphQL中编写fegin调用
    // 3.重新定义传参和返回（需要符合规范）删除graphQL中无用的代码
    // 4.复用重复的代码（参考ers的处理方式）
    // 5.测试接口
}
