package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Component
public class UserRepositoryImpl implements UserRepository {
	
	private static List<User> users = new ArrayList<User>();
	
	
	@Override
	public User add(User user) {
		users.add(user);
		return user;
	}
	@Override
	public User getUserByEmail(String email) {
		User user = null;
		for (User u : users) {
			if(u.getEmail().equals(email)) {
				user=u;
			}
		}
		return user;
	}
	
}
