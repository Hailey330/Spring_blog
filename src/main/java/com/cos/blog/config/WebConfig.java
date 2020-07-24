package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

// web.xml (필터링) 오버라이딩 - implements WebMvcConfigurer

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {	
		
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**") // user 에 관한 인증은 SessionIntercepter가 관리함
		.addPathPatterns("/post/**") // post 에 관한 인증 
		.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**"); // admin 에 관한 인증은 RoleIntercepter가 관리함
	}
}
