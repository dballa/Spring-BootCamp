package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User addUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if(userRepository.getUserByEmail(user.getEmail()) == null) {
			User newUser= userRepository.add(user);
			return newUser;
		}else {
			throw new UserException("User with email : " +user.getEmail() + " already exist!");
			
		}
	}

}
