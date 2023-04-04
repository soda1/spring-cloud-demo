package com.eric.study.cloud.feign;

import com.eric.study.cloud.feign.api.ProviderFeign;
import com.eric.study.cloud.feign.api.ProviderFeignCopy;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * feign集成hystrix, 实现feign api，as hystrix fallback method
 */

@Component
public class ProviderFallBack implements ProviderFeign {


    @Override
    public String getBook(String bookName) {
        return "sever bash";

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
        return "server error";
    }

    @Override
    public String timeout(int time) {
        return "hystrix occur";
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
        return "bad";
    }


}
