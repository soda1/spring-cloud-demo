package com.soda.colod;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class RetryApplication {


    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class);
    }

/*

    @Bean
    @LoadBalanced
    public RestTemplate get() {
        return new RestTemplate();
    }
*/

    @Bean
    @LoadBalanced
    public RestTemplate restTemplateRibbon(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
			.setConnectTimeout(Duration.ofSeconds(1))
                .setReadTimeout(Duration.ofSeconds(1))
                .build();
    }
}
