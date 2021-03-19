package com.shopboot;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.shopboot.entity.UserEntity;
import com.shopboot.repository.UserRepository;


@SpringBootTest
@Transactional
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void givenUsername_whenRetrieved_thenGetUserData() {
		UserEntity user = UserUtil.createUser();
		userRepository.addUser(user);
		String username = "test123";
		
		UserEntity userRetrieved = userRepository.getUserByUsername(username);
		
		Assertions.assertEquals(username, userRetrieved.getUsername());
	}
	
	@Test
	public void givenUser_whenUpdate_thenGetUpdatedUser() {
		UserEntity user = UserUtil.createUser();
		userRepository.addUser(user);
		user.setFirstName("testUpdate");
		
		userRepository.updateUser(user);
		
		Assertions.assertEquals("testUpdate", userRepository.getUserByUsername("test123").getFirstName());
	}
	
	@Test
	public void givenUser_whenSave_thenGetCreatedUser() {
		Integer userSize = userRepository.getAllUsers().size();
		UserEntity user = UserUtil.createUserAdmin();

		userRepository.addUser(user);
		
		Assertions.assertEquals(userSize+1, userRepository.getAllUsers().size());
		Assertions.assertNotNull(userRepository.getUserByUsername("admin123"));
	}
	
	@Test
	public void givenWrongUsername_whenRetrieved_thenGetNoResult() {
		String username = "test";
		
		UserEntity user = userRepository.getUserByUsername(username);
		
		Assertions.assertNull(user);
	}
	
	
	@Test
	public void givenUser_whenSoftDelete_thenGetNoResult() {
		UserEntity user = UserUtil.createUserAdmin();
		userRepository.addUser(user);

		userRepository.softDeleteUser(user);
		
		Assertions.assertNull(userRepository.getUserByUsername("admin123"));
	}

}
