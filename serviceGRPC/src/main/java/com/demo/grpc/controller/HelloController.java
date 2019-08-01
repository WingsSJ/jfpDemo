package com.demo.grpc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : csj
 * @apiNote :
 * @date :2019-07-17
 */
@RestController
@RequestMapping("/serviceGRPC")
@Slf4j
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
