package com.eric.study.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
/**
 * @author eric
 * @date 4/3/2023
 */
@Component
public class LoginFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    // 获取zuul提供的上下文对象
    RequestContext context = RequestContext.getCurrentContext();
    // 从上下文对象中获取请求对象
    HttpServletRequest request = context.getRequest();
    // 获取token信息
    String token = request.getParameter("access-token");
    // 判断
    if (StringUtils.isBlank(token)) {
      //过滤请求,设置为false表示请求不会进入后台路由，但是还是会走其他的filter
      context.setSendZuulResponse(false);
      // 设置响应状态码，401
      context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
      // 设置响应内容，会覆盖后台路由传出来的内容
      context.setResponseBody("{\"status\":\"401\", \"text\":\"request error!\"}");
    }
    // 校验通过，把登陆信息放入上下文信息，继续向后执行
    context.set("token", token);
    return null;
  }
}
