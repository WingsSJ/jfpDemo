package com.demo.serviceA.service;

import com.demo.serviceA.dto.User;
import com.demo.serviceA.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User findUserByUserId(String id) {
        return userMapper.findUserByUserId(id);
    }
}
