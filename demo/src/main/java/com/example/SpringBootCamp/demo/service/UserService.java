package com.example.SpringBootCamp.demo.service;

import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.entity.UserEntity;

public interface UserService {
	
	public UserEntity addUser(UserDtoForCreate user);
	
	public void deleteUser(long id);

}
