package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.entity.UserEntity;

public interface UserService {
	
	public UserEntity addUser(UserEntity user);
	
	public void deleteUser(long id);

}
