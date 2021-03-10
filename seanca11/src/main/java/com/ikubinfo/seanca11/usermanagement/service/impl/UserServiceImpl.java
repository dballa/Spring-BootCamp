package com.ikubinfo.seanca11.usermanagement.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ikubinfo.seanca11.usermanagement.UserManagmentExcpetion;
import com.ikubinfo.seanca11.usermanagement.model.User;
import com.ikubinfo.seanca11.usermanagement.repository.UserRepository;
import com.ikubinfo.seanca11.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) {

		if (userRepository.existUserWithEmail(user.getEmail())) {
			throw new UserManagmentExcpetion("An user with this email exists");

		} else {
			return userRepository.save(user);
		}

	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findUser(user.getEmail());

		if (Objects.isNull(existingUser)) {
			throw new UserManagmentExcpetion("User don't exists");
		}

		existingUser.setAge(user.getAge());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());

		return userRepository.update(existingUser);

	}

	@Override
	public boolean delete(String email) {
		if (!userRepository.existUserWithEmail(email)) {
			throw new UserManagmentExcpetion("An user with this don't exists");

		} else {
			return userRepository.delete(email);
		}

	}

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public User findUser(String email) {

		User existingUser = userRepository.findUser(email);

		if (existingUser == null) {
			throw new UserManagmentExcpetion("An user with email don't exists");
		}
		return existingUser;
	}

}
