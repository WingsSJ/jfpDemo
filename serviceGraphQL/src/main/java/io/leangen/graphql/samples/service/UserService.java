package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.dto.User;
import io.leangen.graphql.samples.repo.UserRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GraphQLApi
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @GraphQLQuery
    public User findUserByUserId(String id) {
        System.out.println("This is Mybatis Method");
        return userRepo.findUserByUserId(id);
    }
}
