package com.yao.microservice.xmg.phaseone.springboot.mvc.exception.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *springmvc拦截器 handler究竟是什么
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/3 09:38
 */
public class DefaultInterceptorHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.printf("handler object : %s \n",handler.toString());
        return true;
    }
}
