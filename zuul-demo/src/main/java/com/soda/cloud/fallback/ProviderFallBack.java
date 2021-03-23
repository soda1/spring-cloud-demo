package com.soda.cloud.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 实现hystrix fallback
 */

@Component
public class ProviderFallBack implements FallbackProvider {

    /**
     * 指定fallback 服务
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 实现fallback返回
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        ClientHttpResponse fallback = fallback(HttpStatus.SERVICE_UNAVAILABLE, "服务出错啦");
        return fallback;
    }

    private ClientHttpResponse fallback(HttpStatus status,  String body) {

       return new ClientHttpResponse(){

           //除了close，其他方法都实现，否则可能报错
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

           @Override
           public InputStream getBody() throws IOException {;
               return new ByteArrayInputStream(body.getBytes("utf-8"));
           }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return status.getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
