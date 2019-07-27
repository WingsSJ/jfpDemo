package io.leangen.graphql.samples.feginService;

import io.leangen.graphql.samples.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeginServiceAImpl implements FeginServiceA {
    @Override
    public User findUserByUserId(String userId) {
        log.error("fall back");
        return new User();
    }
}
