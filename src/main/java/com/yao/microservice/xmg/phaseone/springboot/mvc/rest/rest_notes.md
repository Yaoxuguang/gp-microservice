#### springboot rest
* 1.幂等性
    * 对同一个系统，使用同样的条件，一次请求和重复的多次请求对系统资源的影响是一致的
    * GET、PUT、DELETE(幂等)；POST(非幂等)
    * [幂等的常用思路](https://www.jianshu.com/p/475589f5cd7b)
* 2.RestFul请求类型
    * @GetMapping = @RequestMapping(method = RequestMethod.GET)
    * @PostMapping = @RequestMapping(method = RequestMethod.POST)
    * @PutMapping = @RequestMapping(method = RequestMethod.PUT)
    * @DeleteMapping = @RequestMapping(method = RequestMethod.DELETE)
    ...
* 3.springboot 媒体类型以及自定义媒体类型
    * 浏览器的自描述消息：
        ```
            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,/;q=0.8
    * springboot默认支持的媒体类型："application/json"
    * 查找springboot默认支持的媒体类型的流程：@EnableWebMvc -> DelegatingWebMvcConfiguration -> WebMvcConfigurationSupport#addDefaultHttpMessageConverters
    -> messageConverters(List的特性，先到先服务的原则) -> RequestMappingHandlerAdapter最终控制写出 -> 
    RequestResponseBodyMethodProcessor#handleReturnValue -> AbstractMessageConverterMethodProcessor#writeWithMessageConverters ->
    AbstractGenericHttpMessageConverter#write -> AbstractJackson2HttpMessageConverter#writeInternal
    * 扩展自定义媒体类型
        * 1.继承AbstractHttpMessageConverter，重写方法supports、readInternal、writeInternal
        * 2.web mvc的配置，实现接口WebMvcConfigurer，重写extendMessageConverters方法
        * 3.@RequestMappng 中的 consumes 对应 请求头 “Content-Type”
            @RequestMappng 中的 produces   对应 请求头 “Accept”


