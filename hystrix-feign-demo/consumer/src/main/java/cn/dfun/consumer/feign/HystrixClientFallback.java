package cn.dfun.consumer.feign;

import cn.dfun.consumer.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
