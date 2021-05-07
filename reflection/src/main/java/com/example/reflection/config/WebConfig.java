package com.example.reflection.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.reflection.interceptor.GraphInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:5500")
	    .allowedMethods("POST","GET","PUT","DELETE")
	    .allowedHeaders("*");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration reg = registry.addInterceptor(new GraphInterceptor());
		reg.addPathPatterns("/graphql");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
