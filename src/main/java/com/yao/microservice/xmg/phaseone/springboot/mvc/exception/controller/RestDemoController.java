package com.yao.microservice.xmg.phaseone.springboot.mvc.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/9/2 12:34
 */
@RestController
public class RestDemoController {
    /**
     * springmvc的异常处理,模拟空指针异常
     * @return java.lang.String
     */
    @GetMapping("/doException")
    public String doException(){
        throw new NullPointerException("故意抛出空指针异常...");
    }

    /**
     * springboot的异常处理-错误页面的方式进行处理
     * @return java.lang.String
     */
    @GetMapping("/404.html")
    public Object doSpringbootException( HttpServletRequest request){
        Map<String,Object> errors = new HashMap<>();
        errors.put("statusCode",
                request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri",
                request.getAttribute("javax.servlet.error.request_uri"));
        return errors;
    }
}
