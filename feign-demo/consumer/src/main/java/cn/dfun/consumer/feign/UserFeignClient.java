package cn.dfun.consumer.feign;

import cn.dfun.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("feign-demo-provider")
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User postUser(@RequestBody User user);
}
