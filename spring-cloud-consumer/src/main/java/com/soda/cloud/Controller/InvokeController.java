package com.soda.cloud.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.soda.cloud.feign.api.ProviderFeign;
import com.soda.cloud.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@RestController
public class InvokeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderFeign providerFeign;


/*    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            //超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            //超时开启
            @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000")
    })*/
    @GetMapping("/book/{bookname}")
    public String invokeGetBook(@PathVariable("bookname") String name) throws InterruptedException {

        // String baseUrl = "http://localhost:8080/book/" + name;

        //使用eureka后可以直接写服务名就ok了
         String baseUrl = "http://bookServer/book/" + name;


        //模拟服务熔断
        if (name.equals("西游记")) {
            throw new RuntimeException("服务忙");
        }
        return restTemplate.getForObject(baseUrl, String.class);
//        return providerFeign.getBook(name);

    }



    public String fallBack(String name) {
        return "服务暂时不可用，请稍后再试";
    }


    /**
     * 测试ribbon重试机制 with restTemplate
     * @return
     */
    @GetMapping("/book/retry")
    public ResponseEntity retryTest() {


        String resp = restTemplate.getForObject("http://bookServer/book/retry", String.class);

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

}
