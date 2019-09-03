package com.yao.microservice;

import com.yao.microservice.xmg.phaseone.springboot.mvc.exception.interceptor.DefaultInterceptorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class GpMicroserviceApplication extends WebMvcConfigurerAdapter implements ErrorPageRegistrar {

	public static void main(String[] args) {
		SpringApplication.run(GpMicroserviceApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DefaultInterceptorHandler());
	}

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
		registry.addErrorPages(errorPage);
	}
}
