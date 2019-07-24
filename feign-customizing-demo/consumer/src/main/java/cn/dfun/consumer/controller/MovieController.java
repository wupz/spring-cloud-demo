package cn.dfun.consumer.controller;

import cn.dfun.consumer.entity.User;
import cn.dfun.consumer.feign.EurekaFeignClient;
import cn.dfun.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/{serviceName}")
    public String serviceName(@PathVariable String serviceName) {
        return this.eurekaFeignClient.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}
