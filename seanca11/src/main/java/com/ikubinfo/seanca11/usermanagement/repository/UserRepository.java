package com.ikubinfo.seanca11.usermanagement.repository;

import java.util.List;

import com.ikubinfo.seanca11.usermanagement.model.User;

public interface UserRepository {

	User save(User user);

	User update(User user);

	boolean delete(String email);

	List<User> getAll();

	User findUser(String email);
	
	boolean existUserWithEmail(String email);
}
