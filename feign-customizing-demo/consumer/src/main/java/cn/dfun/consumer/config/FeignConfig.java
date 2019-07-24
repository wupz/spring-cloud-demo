package cn.dfun.consumer.config;

import cn.dfun.consumer.annotation.ExcludeFromComponentScan;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class FeignConfig {
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }
}
