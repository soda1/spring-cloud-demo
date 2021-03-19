package com.soda.colod.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RetryController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/book/retry")
    public String retryTest() {

        String forObject = restTemplate.getForObject("http://bookService/book/retry", String.class);
        return forObject;

    }

    @PostMapping("/book/retry2")
    public String retryTestByPost() {

        String forObject = restTemplate.getForObject("http://bookService/book/retry", String.class);
        return forObject;

    }

    /**
     * 测试超时重试
     * @param sleepTime 休眠时间
     * @return
     */
    @GetMapping("/retry/timeout/{time}")
    public String timeoutRetry(@PathVariable("time") int sleepTime) throws InterruptedException {
        String forObject = restTemplate.getForObject("http://bookService/ribbon/retry/timeout/" + sleepTime, String.class);
        return forObject;
    }
}
