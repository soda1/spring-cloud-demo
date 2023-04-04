package com.study.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;import org.springframework.cloud.client.loadbalancer.LoadBalanced;import org.springframework.cloud.netflix.eureka.EnableEurekaClient;import org.springframework.context.annotation.Bean;import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class);
    }


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
