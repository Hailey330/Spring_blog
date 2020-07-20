package com.cos.blog.repository;

import com.cos.blog.model.User;

// Persistence 만들기  - java object 보관 
// mapper - MyBatis가 띄워줌. 안 뜨면 @Repository로 띄워야 함!
public interface UserRepository {
	public void save(User user); // insert 
	public User login(User user); // select 
	
}
