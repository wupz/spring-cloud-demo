package cn.dfun.consumer.feign;

import cn.dfun.consumer.config.EurekaConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka", url = "http://localhost:8761/", configuration = EurekaConfig.class)
public interface EurekaFeignClient {
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
