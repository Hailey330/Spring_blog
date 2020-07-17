package com.cos.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	// 페이지 요청 - select - GetMapping
	// insert - PostMapping
	@GetMapping({ "", "/" })
	public String index() {
		return "index";
	}

}
