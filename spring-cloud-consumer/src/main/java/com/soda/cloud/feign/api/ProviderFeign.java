package com.soda.cloud.feign.api;

import com.soda.cloud.feign.ProviderFallBack;
import com.soda.cloud.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "bookServer", fallback = ProviderFallBack.class)
public interface ProviderFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/book/{bookName}")
    String getBook(@PathVariable("bookName") String bookName);

    /**
     * fallback测试
     * @return
     */
    @GetMapping("/test/error")
     String error();


    @GetMapping("/ribbon/retry/timeout/{time}")
    String timeout(int time);


    /**
     * 测试feign，get方法请求带单个参数如何写
     * @param param1
     * @return
     */
    @GetMapping("/test/get")
    String getMethodTest(@RequestParam("param1") String param1);


    /**
     * 测试feign，post方法传递单个参数如何写
     * 方法等同于String postMethodTest(@RequestBody String param1);
     * @param param1 param1不加注解，默认加上的是@RequestBody
     * @return
     */
    @PostMapping("/test/post")
    String postMethodTest(String param1);


    /**
     * 测试feign，post方法传递单个参数如何写
     * 方法等同于String postManyTest(@RequestParam("param1")String param1,  @RequestBody String param2, @RequestParam("param3") String param3);
     * @param param1
     * @param param2
     * @param param3
     *
     * @return
     */
    @PostMapping("/test/post/many")
    String postManyTest(  @RequestParam("param1")String param1,  String param2, @RequestParam("param3") String param3);

}
