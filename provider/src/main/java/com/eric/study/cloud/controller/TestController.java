package com.eric.study.cloud.controller;


import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * http method test
 * exception test
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 用于测试cloud组件错误处理机制
     * @return
     */
    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("server error");
    }


    /**
     * post方法接收单参数
     * @param param1
     * @return
     */
    @PostMapping("/post")
    public String postTest(@RequestBody String param1) {

        if (param1 != null) {
            System.out.println("receive success");
            return param1;
        } else {
            return "bad receive";
        }

    }


    /**
     * post方法接收多参数
     * @param param1
     * @return
     */
    @PostMapping("/post/many")
    public String postManyTest( @RequestParam("param1") String param1,  @RequestBody String param2, @RequestParam("param3")String param3) {

        if (param1 != null) {
            System.out.println("receive success");
            return param1 + param2 + param3;
        } else {
            return "bad receive";
        }

    }

    /**
     * get接收参数
     * @param param1
     * @return
     */
    @GetMapping("/get")
    public String getTest(String param1) {

        if (param1 != null) {
            System.out.println("receive success");
            return param1;
        } else {
            return "bad receive";
        }
    }


    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable("time") int sleepTime) throws InterruptedException {

        System.out.println("time start");
        TimeUnit.SECONDS.sleep(sleepTime);
        System.out.println("time end");
        return "success";
    }




}
