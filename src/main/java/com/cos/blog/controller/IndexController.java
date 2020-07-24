package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	// 페이지 요청 - select - GetMapping
	// insert - PostMapping
	@GetMapping({ "", "/" })
	public String index() {
		return "index";
	}
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; // redirect하면 주소 요청되면서 위의 "/"로 감 → index 페이지
	}

}
