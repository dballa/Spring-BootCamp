package com.example.SpringBootCamp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserService;
import com.example.SpringBootCamp.demo.service.impl.UserServiceImpl;
import com.example.SpringBootCamp.demo.exceptions.*;

@RestController
public class UserController {

	@Autowired
	UserService userSevice;

	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable long id) {
		userSevice.deleteUser(id);

	}

	@PostMapping("/addUser")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userSevice.addUser(user);
	}

}
