package cn.dfun.consumer.feign;

import cn.dfun.consumer.config.FeignConfig;
import cn.dfun.consumer.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "feign-demo-provider", configuration = FeignConfig.class)
public interface UserFeignClient {
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
