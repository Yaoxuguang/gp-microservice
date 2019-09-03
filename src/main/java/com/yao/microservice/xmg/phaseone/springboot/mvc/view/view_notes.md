#### springboot视图技术
* 请求流程：
    * RequestURI -> RequestMappingHandlerMapping -> HandleMethod ->
     return "viewName" -> 完整的页面名称 = prefix + "viewName" + suffix ->
     ViewResolver -> View -> render -> html
    * ContentNegotiationViewResolver
    * 以视图类型thymeleaf为例，ThymeleafAutoConfiguration(Thymeleaf自动装配类)
#### springboot 国际化
* MessageSourceAutoConfiguration(国际化自动装配类)
* LocaleContextHolder ->获取当前请求的Locale