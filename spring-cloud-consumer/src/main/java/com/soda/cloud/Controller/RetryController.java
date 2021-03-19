package com.soda.cloud.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/ribbon")
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * get方法测试ribbon重试机制
     * @param statusCode
     * @return
     */
    @GetMapping("/retry/{statusCode}")
    public String retryTest(@PathVariable("statusCode") Integer statusCode) {

        String forObject = restTemplate.getForObject("http://bookServer/ribbon/retry/" + statusCode, String.class);
        return forObject;

    }

    /**
     * post方法测试ribbon重试机制
     * @param statusCode
     * @return
     */
    @PostMapping("/retry/{statusCode}")
    public String retryTestByPost(@PathVariable("statusCode") Integer statusCode) {

        String forObject = restTemplate.getForObject("http://bookServer/ribbon/retry/" + statusCode, String.class);
        return forObject;

    }


    /**
     * 测试超时重试
     * @param sleepTime 休眠时间
     * @return
     */
    @GetMapping("/retry/timeout/{time}")
    public String timeoutRetry(@PathVariable("time") int sleepTime) throws InterruptedException {
        String forObject = restTemplate.getForObject("http://bookServer/ribbon/retry/timeout/" + sleepTime, String.class);
        return forObject;
    }
}
