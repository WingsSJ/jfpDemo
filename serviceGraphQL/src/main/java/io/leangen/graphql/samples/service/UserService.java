package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.model.User;
import io.leangen.graphql.samples.model.UserOwnBook;
import io.leangen.graphql.samples.repo.UserRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @GraphQLQuery
    public User findUserByUserId(String id) {
        return userRepo.findUserByUserId(id);
    }

    @GraphQLQuery
    public List<UserOwnBook> findAll(String id){
        return userRepo.findAll(id);
    }
}
