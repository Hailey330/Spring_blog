package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.dto.WithdrawRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired // DI
	private AccountRepository accountRepository;

	// update가 2번 일어남 → 하나라도 실패하면 rollback : @Transactional, 성공하면 commit
	@Transactional
	public void 송금(SendRequestDto dto) { 
		// 보내는 사람 업데이트 : money -
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);

		// 받는 사람 업데이트 : money +
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney() + dto.getMoney());
		accountRepository.update(장보고);
	}

	@Transactional
	public void 인출(WithdrawRequestDto dto) { 
		// a1 홍길동 업데이트
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber()); // persistence 생성 → DB랑 동기화 되어있는 데이터
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
	}

	@Transactional(readOnly = true)
	// SELECT - 왜 @Transactional 달아야할까? 고립성, 데이터의 정합성 때문
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();
	}
}
