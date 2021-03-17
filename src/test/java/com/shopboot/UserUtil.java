package com.shopboot;

import java.time.LocalDateTime;

import com.shopboot.entity.UserEntity;

public class UserUtil {

	public static UserEntity createUser() {
		UserEntity user = new UserEntity();
		user.setFirstName("test");
		user.setLastName("test");
		user.setEmail("test@gmail.com");
		user.setPassword("test");
		user.setUsername("test123");
		user.setValid(Boolean.TRUE);
		return user;
	}
	
	public static UserEntity createUserAdmin() {
		UserEntity user = new UserEntity();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setEmail("admin@gmail.com");
		user.setPassword("admin");
		user.setUsername("admin123");
		user.setValid(Boolean.TRUE);
		user.setCreatedOn(LocalDateTime.now());
		return user;
	}
}
