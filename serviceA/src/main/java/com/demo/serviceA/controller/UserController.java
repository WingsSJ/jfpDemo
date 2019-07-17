package com.demo.serviceA.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.serviceA.dto.User;
import com.demo.serviceA.feginService.FeignServiceB;
import com.demo.serviceA.ro.UserRO;
import com.demo.serviceA.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : csj
 * @apiNote :
 * @date :2019-07-17
 */
@RestController
@RequestMapping("/serviceA")
@Slf4j
public class UserController {
    private final UserService userService;
    private final FeignServiceB feignServiceB;
    @Autowired
    UserController(UserService userService,FeignServiceB feignServiceB) {
        this.userService = userService;
        this.feignServiceB = feignServiceB;
    }
    @PostMapping("/testA")
    public JSONObject testA(@RequestBody UserRO userRO) {
        User userByUserId = userService.findUserByUserId(userRO.getId());
        return JSONObject.parseObject(JSON.toJSONString(userByUserId));
    }

    @RequestMapping("/testB")
    public String testB(){
        return feignServiceB.test();
    }
}
