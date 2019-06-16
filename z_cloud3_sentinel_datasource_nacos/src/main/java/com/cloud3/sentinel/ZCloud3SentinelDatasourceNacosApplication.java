package com.cloud3.sentinel;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ZCloud3SentinelDatasourceNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3SentinelDatasourceNacosApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @GetMapping(Constants.CLOUD3 + "/hello")
        public String hello() {
            return "hello sentinel";
        }

    }

}
