package com.cloud3.nacos;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ZCloud3NacosDiscoveryClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3NacosDiscoveryClientFeignApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @Autowired
        Client client;

        @GetMapping(Constants.CLOUD3 + "/test")
        public String test() {
            String result = client.hello("didi");
            return "Return : " + result;
        }
    }


    @FeignClient("zCloud3NacosDiscoveryServer")
    interface Client {

        @GetMapping(Constants.CLOUD3 + "/hello")
        String hello(@RequestParam(name = "name") String name);

    }

}
