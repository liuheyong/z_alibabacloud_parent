package com.cloud3.nacos;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ZCloud3NacosDiscoveryServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3NacosDiscoveryServer2Application.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @GetMapping(Constants.CLOUD3 + "/hello")
        public String hello(@RequestParam String name) {
            return "hello " + name;
        }

    }

}
