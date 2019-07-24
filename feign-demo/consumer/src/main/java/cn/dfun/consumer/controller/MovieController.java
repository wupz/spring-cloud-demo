package cn.dfun.consumer.controller;

import cn.dfun.consumer.entity.User;
import cn.dfun.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @PostMapping("/testPost")
    public User testPost(@RequestBody User user) {
        return this.userFeignClient.postUser(user);
    }
}
