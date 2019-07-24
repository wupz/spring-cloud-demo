package cn.dfun.consumer;

import cn.dfun.consumer.annotation.ExcludeFromComponentScan;
import cn.dfun.consumer.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate添加@LoadBalanced注解
 * 启动类添加@RibbonClient注解指定配置文件
 * 不Ribbion配置文件所在的包
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
@RibbonClient(name = "ribbon-demo-provider", configuration = RibbonConfig.class)
public class ConsumerApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
