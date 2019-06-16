package com.cloud3.nacos;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ZCloud3NacosDiscoveryClientResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3NacosDiscoveryClientResttemplateApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @Autowired
        RestTemplate restTemplate;

        @GetMapping(Constants.CLOUD3 + "/test")
        public String test() {
            String result = restTemplate.getForObject("http://zCloud3NacosDiscoveryServer/cloud3/hello?name=codedog", String.class);
            return "Return : " + result;
        }
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
