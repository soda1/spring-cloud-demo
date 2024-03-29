package com.eric.study.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class);
    }

}
