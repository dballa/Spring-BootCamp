package com.example.SpringBootCamp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userSevice;

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable long id) {
		userSevice.deleteUser(id);

	}

	@PostMapping("/addUser")
	public UserDto addUser(@RequestBody UserDtoForCreate user) {
		
		
		return UserConverter.toDto(userSevice.addUser(user));
	}

}
