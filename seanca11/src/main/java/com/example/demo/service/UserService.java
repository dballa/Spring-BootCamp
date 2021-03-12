package com.example.demo.service;

import com.example.demo.UserException;
import com.example.demo.model.User;

public interface UserService {
	
	User addUser(User user) throws UserException;
}
