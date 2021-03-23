package com.example.SpringBootCamp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/hello")
	public List<UserEntity> hello() {
		List<UserEntity> l=userRepository.getAllUsers();
	return l;
	}

}
