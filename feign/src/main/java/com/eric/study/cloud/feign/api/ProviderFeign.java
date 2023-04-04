package com.eric.study.cloud.feign.api;

import com.eric.study.cloud.feign.ProviderFallBack;
import com.eric.study.cloud.feign.ProviderFeignFallbackFactory;import com.sun.org.slf4j.internal.LoggerFactory;import feign.Logger;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@FeignClient(
    name = "provider-server",
    path = "/provider",
    configuration = ProviderFeignConfig.class,
    fallbackFactory = ProviderFeignFallbackFactory.class
)
public interface ProviderFeign {

  @RequestMapping(method = RequestMethod.GET, value = "/book/{bookName}")
  String getBook(@PathVariable("bookName") String name);

  @RequestMapping(method = RequestMethod.POST, value = "/book/", consumes = "application/json")
  String addBook(@RequestBody String name);

  @RequestMapping(method = RequestMethod.DELETE, value = "/book/{bookName}")
  String deleteBook(@PathVariable("bookName") String name);

  @RequestMapping(method = RequestMethod.GET, value = "/book/list")
  Set<String> bookList();

  /**
   * fallback测试
   *
   * @return
   */
  @GetMapping("/test/error")
  String error();

  /**
   * 测试feign，get方法请求带单个参数如何写
   *
   * @param param1
   * @return
   */
  @GetMapping("/test/get")
  String getMethodTest(@RequestParam("param1") String param1);

  /**
   * 测试feign，post方法传递单个参数如何写 方法等同于String postMethodTest(@RequestBody String param1);
   *
   * @param param1 param1不加注解，默认加上的是@RequestBody
   * @return
   */
  @PostMapping("/test/post")
  String postMethodTest(String param1);

  /**
   * 测试feign，post方法传递单个参数如何写 方法等同于String postManyTest(@RequestParam("param1")String
   * param1, @RequestBody String param2, @RequestParam("param3") String param3);
   *
   * @param param1
   * @param param2
   * @param param3
   * @return
   */
  @PostMapping("/test/post/many")
  String postManyTest(
      @RequestParam("param1") String param1, String param2, @RequestParam("param3") String param3);

  /**
   * 测试feign超时
   *
   * @param sleepTime
   * @return
   */
  @GetMapping("/hystrix/timeout/{time}")
  String timeout(@PathVariable("time") int sleepTime);
}

// @Configuration
class ProviderFeignConfig {
  // config feign log level
  @Bean
  public Logger.Level logger() {
    return Logger.Level.NONE;
  }
}