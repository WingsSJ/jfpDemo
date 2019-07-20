package io.leangen.graphql.samples.mapper;

import io.leangen.graphql.samples.model.User;
import io.leangen.graphql.samples.model.UserOwnBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByUserId(@Param("id") String id);
    List<UserOwnBook> findAll(@Param("id") String id);
}

