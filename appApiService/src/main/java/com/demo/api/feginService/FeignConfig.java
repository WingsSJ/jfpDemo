package com.demo.api.feginService;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Request.Options feignOptions() {
        return new Request.Options(10 * 1000,20 * 1000);
    }
}
