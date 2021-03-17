package com.shopboot;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopboot.entity.UserEntity;
import com.shopboot.repository.UserRepository;


@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Order(1)
	public void givenUsername_whenRetrieved_thenGetUserData() {
		UserEntity user = UserUtil.createUser();
		userRepository.addUser(user);
		String username = "test123";
		
		UserEntity userRetrieved = userRepository.getUserByUsername(username);
		
		Assertions.assertEquals(username, userRetrieved.getUsername());
	}
	
	@Test
	@Order(2)
	public void givenUser_whenUpdate_thenGetUpdatedUser() {
		UserEntity user = userRepository.getUserByUsername("test123");
		user.setFirstName("testUpdate");
		
		userRepository.updateUser(user);
		
		Assertions.assertEquals("testUpdate", userRepository.getUserByUsername("test123").getFirstName());
	}
	
	@Test
	@Order(3)
	public void givenUser_whenSave_thenGetCreatedUser() {
		Integer userSize = userRepository.getAllUsers().size();
		UserEntity user = UserUtil.createUserAdmin();

		userRepository.addUser(user);
		
		Assertions.assertEquals(userSize+1, userRepository.getAllUsers().size());
		Assertions.assertNotNull(userRepository.getUserByUsername("admin123"));
	}
	
	@Test
	@Order(4)
	public void givenWrongUsername_whenRetrieved_thenGetNoResult() {
		String username = "test";
		
		UserEntity user = userRepository.getUserByUsername(username);
		
		Assertions.assertNull(user);
	}
	
	
	@Test
	@Order(5)
	public void givenUser_whenSoftDelete_thenGetNoResult() {
		UserEntity user = userRepository.getUserByUsername("admin123");

		userRepository.softDeleteUser(user);
		
		Assertions.assertNull(userRepository.getUserByUsername("admin123"));
	}

}
