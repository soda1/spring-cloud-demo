package com.eric.study.cloud.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/ribbon")
public class RibbonTestController {

    /**
     *
     * 返回客户端指定状态码，测试ribbon重试机制
     * get方法测试
     * @return
     */
    @GetMapping("/retry/{statusCode}")
    public ResponseEntity<String> retryFaceByGet(@PathVariable("statusCode") Integer statusCode) {

        System.out.println("Get request come in");
        return new ResponseEntity<>(HttpStatus.resolve(statusCode));
    }

    /**
     * 返回客户端指定状态码，测试ribbon重试机制
     * post方法测试
     * @return
     */

    @PostMapping("/retry/{statusCode}")
    public ResponseEntity<String> retryFaceByPost(@PathVariable("statusCode") Integer statusCode) {

        System.out.println("Post request come in");
        return new ResponseEntity<>(HttpStatus.resolve(statusCode));


    }


    /**
     * 测试超时重试
     * @param sleepTime 休眠时间
     * @return
     */
    @GetMapping("/retry/timeout/{time}")
    public ResponseEntity<String> timeoutRetry(@PathVariable("time") int sleepTime) throws InterruptedException {
        System.out.println("timeout retry start");
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("end");
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
