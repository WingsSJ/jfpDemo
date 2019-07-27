package io.leangen.graphql.samples.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.samples.feginService.FeginServiceA;
import io.leangen.graphql.samples.model.User;
import io.leangen.graphql.samples.model.UserOwnBook;
import io.leangen.graphql.samples.repo.UserRepo;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@GraphQLApi
@Slf4j
@Service
public class UserService {
    @Autowired
    private FeginServiceA feginServiceA;
    @Autowired
    private UserRepo userRepo;

    @GraphQLQuery
    public User findUserByUserId(String id) {
        User userByUserId = feginServiceA.findUserByUserId(id);
        log.info("it is GraphQL service");
        return userByUserId;
    }
    @GraphQLQuery
    public List<UserOwnBook> findAll(String id){
        return userRepo.findAll(id);
    }
}
