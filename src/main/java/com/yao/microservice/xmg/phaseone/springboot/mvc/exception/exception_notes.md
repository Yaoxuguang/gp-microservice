#### 传统servlet的异常处理
* 错误页面的方式
    ``` 
        <error-page>
            <error-code>404</error-code>
            <exception-type>异常类型</exception-type>
            <location>/404</location>
        </error-page>  
  
#### spring mvc的异常处理
* @ExceptionHandler
* @RestControllerAdvice = @ControllerAdvice + @ResponseBody
* @ControllerAdvice 专门拦截（AOP） @Controller

#### springboot的异常处理
* 实现 ErrorPageRegistrar接口
* 定义ErrorPage
* 注册addErrorPages(ErrorPage errorPage)