package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.model.user.User;

@Controller
public class UserController {

	@PostMapping("/auth/joinProc")
	// @ResponseBody : html말고 데이터를 받기 위해서
	public @ResponseBody User joinProc(@RequestBody User user) { 		
		return user;
	}
}
