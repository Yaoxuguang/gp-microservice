package com.yao.microservice.xmg.phaseone.springboot.mvc.exception.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * springmvc异常处理类
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/2 12:28
 */
@RestControllerAdvice(basePackages = "com.yao.microservice.xmg.phaseone.springboot.mvc.controller")
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = {NullPointerException.class})
    public Object handexception(Throwable throwable){
        Map<String,Object> data = new HashMap<>();
        data.put("message",throwable.getMessage());
        return data;
    }
}
