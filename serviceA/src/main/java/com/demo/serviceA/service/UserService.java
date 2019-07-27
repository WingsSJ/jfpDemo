package com.demo.serviceA.service;

import com.demo.serviceA.dto.User;
import com.demo.serviceA.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User findUserByUserId(@RequestParam(name = "id")String id) {
        log.info("it is service A");
        return userMapper.findUserByUserId(id);
    }
}
