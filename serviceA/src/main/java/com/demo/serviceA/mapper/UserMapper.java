package com.demo.serviceA.mapper;

import com.demo.serviceA.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findUserByUserId(@Param("id") String id);
}
