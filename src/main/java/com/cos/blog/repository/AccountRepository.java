package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.model.Account;

public interface AccountRepository {
	
	public void update(Account account);
	public List<Account> findAll(); // return 되는 Object를 Repository가 들고 있음 → persistence 
	public Account findByAccountNumber(String accountNumber);
}
