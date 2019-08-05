package com.demo.grpc.config;

import com.topsec.ptoken.core.TokenUtils;
import com.topsec.util.json.JackJson;
import io.grpc.BindableService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 系统配置
 *
 * @auther jasonx
 * @create 5/21/18 4:54 PM
 **/
@Configuration
public class SysConfig {
    @Bean
    public TokenUtils tokenUtils(){
        return new TokenUtils();
    }
    @Bean
    public JackJson jackJson(){
        return new JackJson();
    }
}
