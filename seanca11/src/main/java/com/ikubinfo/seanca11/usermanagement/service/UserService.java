package com.ikubinfo.seanca11.usermanagement.service;

import java.util.List;

import com.ikubinfo.seanca11.usermanagement.model.User;

public interface UserService {

	User addUser(User user);

	User updateUser(User user);

	boolean delete(String email);

	List<User> getAll();

	User findUser(String email);

}
