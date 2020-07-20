package com.cos.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommonRespDto<T> {
	private int statusCode; // 1 정상, -1 실패, 0 변경안됨 : 공통적인 응답을 해줄 수 있음
	private T data; // SELECT, 응답할 때 데이터 넣어줌 → 동적으로 Object 담음 (제너릭 활용)
}
