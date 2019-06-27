package com.coud3.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TestTopic.class)
@SpringBootApplication
public class ZCloud3StreamConsumerSelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZCloud3StreamConsumerSelfApplication.class, args);
    }

}
