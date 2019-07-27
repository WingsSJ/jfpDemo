package com.demo.serviceA.controller;

import com.demo.serviceA.dto.User;
import com.demo.serviceA.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/test/find/user/by/id")
    public User findUserByUserId(@Param("id") String id) {
        return  userService.findUserByUserId(id);
    }
}
