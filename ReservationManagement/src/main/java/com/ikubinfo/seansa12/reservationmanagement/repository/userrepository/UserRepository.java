package com.ikubinfo.seansa12.reservationmanagement.repository.userrepository;

import java.util.List;

import com.ikubinfo.seansa12.reservationmanagement.model.user.User;

public interface UserRepository {
	
	User save(User user);

	User update(User user);

	boolean delete(String username);

	List<User> getAll();

	User findUser(String username);

	boolean existUserWithUsername(String username);

}
