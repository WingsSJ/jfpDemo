package com.demo.channel.mapper;

import com.demo.channel.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findUserByUserId(@Param("id") String id);
}
