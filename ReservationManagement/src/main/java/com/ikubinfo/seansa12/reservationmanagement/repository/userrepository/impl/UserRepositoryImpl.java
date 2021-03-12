package com.ikubinfo.seansa12.reservationmanagement.repository.userrepository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ikubinfo.seansa12.reservationmanagement.model.user.User;
import com.ikubinfo.seansa12.reservationmanagement.repository.userrepository.UserRepository;

@Component
public class UserRepositoryImpl implements UserRepository{

	private List<User> users = new ArrayList<>();

	@Override
	public User save(User user) {
		
		if(users.add(user)) {
			return user;
		}else {
			return null;
		}
		
	}

	@Override
	public User update(User user) {

		for (User existingUser : users){
			if (existingUser.getUsername().equals(user.getUsername())) {
				users.set(users.indexOf(existingUser), user);
				return user;
			}
		}
		return null;
		
	}

	@Override
	public boolean delete(String username) {

		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return users.remove(user);
			}
		}
		return false;
	}

	@Override
	public List<User> getAll() {

		return users;
	}

	@Override
	public User findUser(String username) {

		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean existUserWithUsername(String username) {

		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

}
