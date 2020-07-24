package com.cos.blog.config.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.model.User;

// 인증 관리 
public class SessionIntercepter extends HandlerInterceptorAdapter {
	// implements HandlerInterceptor를 사용해도 되지만 더 편하게 쓸 수 있는 HandlerInterceptorAdapter를 사용한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		if (principal == null) {
			response.setContentType("text/html; charset=UTF-8");
			// response 구현 : 메시지 띄우던지 메인 화면으로 돌려보내던지
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인이 필요합니다.');");
			out.print("location.href='/auth/loginForm'");
			out.print("</script>");
			return false; // 더 이상 진입 불가. 바로 response 됨!
		}
		return true;
	}
}
