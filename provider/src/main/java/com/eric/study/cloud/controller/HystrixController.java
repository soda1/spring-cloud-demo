package com.eric.study.cloud.controller;


import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 *
 * test hystrix mechain
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    /**
     * server error
     * @return
     */
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("server error");
    }

    /**
     * server response time out
     * @param sleepTime
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable("time") int sleepTime) throws InterruptedException {

        System.out.println("time start");
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("time end");
        return "success";
    }




}
