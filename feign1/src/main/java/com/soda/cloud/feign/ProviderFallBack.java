package com.soda.cloud.feign;

import com.soda.cloud.feign.api.ProviderFeign;
import org.springframework.stereotype.Component;

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
