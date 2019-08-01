package cn.dfun.consumer.feign;

import cn.dfun.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-demo-provider",fallback = HystrixClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
