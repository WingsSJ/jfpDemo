package io.leangen.graphql.samples.feginService;

import io.leangen.graphql.samples.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "serviceA",fallback = FeginServiceAImpl.class,configuration = FeignConfig.class)
public interface FeginServiceA {
    @RequestMapping("/serviceA/test/find/user/by/id")
    User findUserByUserId(@RequestParam(name = "id")String id);
}
