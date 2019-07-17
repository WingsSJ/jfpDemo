package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findUserByUserId(@Param("id") String id);
}
