package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// composition(User user) 하지 말기! 
// field명을 적어야 나중에 찾을 때 편함

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostDetailRespDto {
	private int id;
	private String title;
	private String content;
	private String username;
}
