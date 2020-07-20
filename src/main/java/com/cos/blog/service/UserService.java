package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.user.User;
import com.cos.blog.repository.UserRepository;

// Controller, Repository, Configuration, Service, Component
// RestController, Bean

@Service // IoC - 스프링이 메모리에 띄워줌
public class UserService {

	@Autowired
	private UserRepository userRepository; // DI

	@Transactional
	public int 회원가입(User user) {
		userRepository.save(user);
		return 1;
	}
}