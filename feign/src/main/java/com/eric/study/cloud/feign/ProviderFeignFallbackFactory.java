package com.eric.study.cloud.feign;

import com.eric.study.cloud.feign.api.ProviderFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Set;
/**
 * @author eric
 * @date 4/2/2023
 */
@Component
public class ProviderFeignFallbackFactory implements FallbackFactory<ProviderFeign> {

  @Override
  public ProviderFeign create(Throwable cause) {
    return new ProviderFeign() {
      Logger logger = LoggerFactory.getLogger(ProviderFeign.class);

      @Override
      public String getBook(String name) {

        return null;
      }

      @Override
      public String addBook(String name) {
        return null;
      }

      @Override
      public String deleteBook(String name) {
        return null;
      }

      @Override
      public Set<String> bookList() {
        return null;
      }

      @Override
      public String error() {
        return null;
      }

      @Override
      public String getMethodTest(String param1) {
        return null;
      }

      @Override
      public String postMethodTest(String param1) {
        return null;
      }

      @Override
      public String postManyTest(String param1, String param2, String param3) {
        return null;
      }

      @Override
      public String timeout(int sleepTime) {
        logger.error("error info: " + cause.getMessage());
        System.out.printf("server unavailable");
        return "server unavailable";
      }
    };
  }
}
