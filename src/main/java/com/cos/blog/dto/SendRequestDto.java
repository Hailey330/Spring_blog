package com.cos.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SendRequestDto {
	// 누가, 누구에게, 얼마를
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private int money;
}
