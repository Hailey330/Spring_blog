package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 꼭 필요한 것(final)에 대한 필드의 Constructor 만듦
public class PostController {

	private final PostService postService;
	
//	 @Autowired랑 동일함
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}
	
	// post 관련된 것은 전부 다 인증 필요함 
	@GetMapping("/posts")
	public String getPosts(Model model) { // index 까지 model 데이터 들고 감
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
}
