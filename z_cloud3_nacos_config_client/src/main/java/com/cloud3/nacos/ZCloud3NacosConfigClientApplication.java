package com.cloud3.nacos;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ZCloud3NacosConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3NacosConfigClientApplication.class, args);
    }

    @Slf4j
    @RestController
    @RefreshScope
    static class TestController {

        @Value("${id:}")
        private String title;

        @GetMapping(Constants.CLOUD3 + "/test")
        public String hello() {
            return title;
        }

    }

    /**
     * 多文件加载的例子使用的验证接口
     */
    @Slf4j
    @RestController
    @RefreshScope
    static class Test2Controller {
        @Value("${id:}")
        private String title;
        @Value("${aaa:}")
        private String aaa;
        @Value("${bbb:}")
        private String bbb;

        @GetMapping(Constants.CLOUD3 + "/test2")
        public String test2() {
            return title + ", " + aaa + ", " + bbb;
        }

    }

}
