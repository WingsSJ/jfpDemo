package com.demo.serviceA.feginService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "serviceB",fallback = FeginServiceBImpl.class,configuration = FeignConfigB.class)
public interface FeignServiceB {
    @RequestMapping("/serviceB/hello")
    String test();
}
