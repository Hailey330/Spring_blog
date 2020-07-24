package com.cos.blog.config.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.config.handler.exception.MySessionException;

@ControllerAdvice // IoC 등록 - Exception을 낚아채는 컨트롤러
@RestController
public class GlobalExceptionHandler {

	// Exception의 종류마다 컨트롤 할 수 있음
	@ExceptionHandler(value=MySessionException.class) // like GetMapping
	public String sessionException(Exception e) {
		// user 인증 없음
		return "<h1>인증 없어요 나가세요</h1>";
	}
	
	@ExceptionHandler(value=MyRoleException.class) // like GetMapping
	public String roleException(Exception e) {
		// admin 권한 없음
		return "<h1>권한 없어요 나가세요</h1>";
	}
}
