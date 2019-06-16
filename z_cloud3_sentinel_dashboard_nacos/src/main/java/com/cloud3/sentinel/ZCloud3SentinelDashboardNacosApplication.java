package com.cloud3.sentinel;

import com.alibaba.csp.sentinel.init.InitExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZCloud3SentinelDashboardNacosApplication {

    public static void main(String[] args) {
        triggerSentinelInit();
        SpringApplication.run(ZCloud3SentinelDashboardNacosApplication.class, args);
    }

    private static void triggerSentinelInit() {
        new Thread(() -> InitExecutor.doInit()).start();
    }

}
