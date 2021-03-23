package com.soda.cloud.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter {


    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        System.out.println("pre filter running");
        //需要权限的路径
        String url = "http://localhost:8084/api/common/admin";
        //获取url携带的role参数，模拟权限拦截
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取角色
        String role = currentContext.getRequest().getParameter("role");
        System.out.println(role);
        //获取url
        StringBuffer requestURL = currentContext.getRequest().getRequestURL();

        if (requestURL.toString().equals(url)) {
            if (!role .equals("admin") ) {
                //过滤请求,设置为false表示请求不会进入后台服务，但是还是会走其他的filter
                currentContext.setSendZuulResponse(false);

                //设置响应码
                currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

                //设置响应内容，会覆盖后台服务传出来的内容
                currentContext.setResponseBody("no enough privilege");

            }
            return null;

        }


        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
