package io.leangen.graphql.samples.repo;

import io.leangen.graphql.samples.dto.User;
import io.leangen.graphql.samples.dto.UserOwnBook;
import io.leangen.graphql.samples.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserRepo {
    @Resource
    private UserMapper userMapper;

    public User findUserByUserId(String id) {
        System.out.println("This is Mybatis Method");
        return userMapper.findUserByUserId(id);
    }

    public List<UserOwnBook> findAll(String id){
        return userMapper.findAll(id);
    }
}
