package com.cloud3.nacos;

import com.cloud3.commons.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@SpringBootApplication
public class ZCloud3NacosDiscoveryClientWebclientApplication {

    @Slf4j
    @RestController
    static class TestController {

        @Autowired
        private WebClient.Builder webClientBuilder;

        @GetMapping(Constants.CLOUD3 + "/test")
        public Mono<String> test() {
            Mono<String> result = webClientBuilder.build()
                    .get()
                    .uri("http://zCloud3NacosDiscoveryServer/cloud3/hello?name=codedog")
                    .retrieve()
                    .bodyToMono(String.class);
            return result;
        }
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

}
