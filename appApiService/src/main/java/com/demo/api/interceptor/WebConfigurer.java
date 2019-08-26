package com.demo.api.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @TokenRequired 注解 决定是否需要登录
        registry.addInterceptor(TokenInterceptor()).addPathPatterns("/app/**");
//        registry.addInterceptor(AuthorityInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public TokenInterceptor TokenInterceptor() {
        return new TokenInterceptor();
    }

//    @Bean
//    public AuthorityInterceptor AuthorityInterceptor() {
//        return new AuthorityInterceptor();
//    }
}