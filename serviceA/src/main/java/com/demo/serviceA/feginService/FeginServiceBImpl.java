package com.demo.serviceA.feginService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeginServiceBImpl implements FeignServiceB {
    @Override
    public String test() {
        return "fail back";
    }
}
