package com.ikubinfo.seanca11.usermanagement.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.ikubinfo.seanca11.usermanagement.model.User;
import com.ikubinfo.seanca11.usermanagement.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private List<User> users = new ArrayList<User>();

	@Override
	public User save(User user) {
		users.add(user);
		return null;
	}

	@Override
	public User update(User user) {
		
		return null;
	}

	@Override
	public boolean delete(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User findUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existUserWithEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
