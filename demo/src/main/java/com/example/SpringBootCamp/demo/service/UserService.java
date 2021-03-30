package com.example.SpringBootCamp.demo.service;

import java.util.List;

import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.entity.UserEntity;

public interface UserService {
	
	public UserEntity addUser(UserDtoForCreate user);
	
	public void deleteUser(long id);
	
	public void testTransaction();
	
	public List<UserEntity> getUsers(String name);
	
	public void testRest();

}
