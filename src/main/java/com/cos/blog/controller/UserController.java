package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService; // userService는 톰캣 시작 시 뜨고 request는 사용자가 요청할 때 뜸
	
	@PostMapping("/auth/joinProc")
	// @ResponseBody : html말고 데이터를 받기 위해서
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) {
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입 결과 : 성공");
	}

	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session) {
		User persistUser = userService.로그인(user);
		// requestUser 정보와 구분하려고 persistUser → DB의 User
		if (ObjectUtils.isEmpty(persistUser)) {
			System.out.println("persistUser 없음");
			return new CommonRespDto<String>(-1, "로그인 결과 : 실패");
		} else {
			System.out.println("persistUser 있음");
			// 세션 등록
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 결과 : 성공");
		}
	}
}
