package com.study.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/hystrix")
public class HystrixController {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorFall")
    @GetMapping("/error")
    public String error() {
        String errInfo = restTemplate.getForObject("http://localhost:8087/provider/hystrix/error", String.class);
        System.out.printf(errInfo);
        return errInfo;
    }


    @HystrixCommand(fallbackMethod = "errorFall1", commandKey = "timeoutKey")
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable("time") Integer time) {
        String errInfo = restTemplate.getForObject("http://localhost:8087/provider/hystrix/timeout/" + time, String.class);
        return errInfo;
    }

    public String errorFall(){
        return "error fall back";
    }
    public String errorFall1(Integer time){
        return "error fall back";
    }



}
