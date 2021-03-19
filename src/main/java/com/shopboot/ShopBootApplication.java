package com.shopboot;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopboot.entity.RoleEntity;
import com.shopboot.entity.UserEntity;
import com.shopboot.repository.UserRepository;

@SpringBootApplication
public class ShopBootApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(ShopBootApplication.class);
		app.run();
	}

	@Override
	public void run(String... args) throws Exception {
//		List<UserEntity> users = userRepository.getAllUsers();
//		for (UserEntity userEntity : users) {
//			for (RoleEntity role : userEntity.getRoles()) {
//			}		
//		}
		
		List<UserEntity> users = userRepository.getAllUsersFetched();
		for (UserEntity userEntity : users) {
			for (RoleEntity role : userEntity.getRoles()) {
			}		
		}
	}

	public static UserEntity createUser() {
		UserEntity user = new UserEntity();
		user.setFirstName("klevis");
		user.setLastName("klevis");
		user.setEmail("klevis@gmail.com");
		user.setPassword("klevis");
		user.setUsername("klevis123");
		user.setValid(Boolean.TRUE);
		user.setCreatedOn(LocalDateTime.now());
		return user;
	}
	
}
