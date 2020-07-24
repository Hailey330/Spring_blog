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
//		registry.addInterceptor(new HandlerInterceptor() {
//			@Override
//			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//					throws Exception {
//				// 함수 진입 직전을 컨트롤 할 수 있다. → 인터셉터
//				// 어떤 함수를 컨트롤 할 지 정해야 한다. 
//				return true;
//			}
//		})
//		.addPathPatterns("/user/**") // 유저 쪽으로 들어오는 모든 것은 인증이 필요하다.
//		.addPathPatterns("/admin/**"); // 관리자 쪽으로 들어오는 모든 것은 인증 및 권한이 필요하다. 
//	}
		
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**"); // user 에 관한 인증은 SessionIntercepter가 관리함
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**"); // admin 에 관한 인증은 RoleIntercepter가 관리함
	}
}
