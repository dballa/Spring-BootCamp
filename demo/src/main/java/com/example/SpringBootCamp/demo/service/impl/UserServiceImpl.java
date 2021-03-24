package com.example.SpringBootCamp.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.entity.SubscriptionEntity;
import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.exceptions.CustomUserException;
import com.example.SpringBootCamp.demo.repository.SubscriptionRepository;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserService;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Value("${ageAllowedToDelete}")
	private int ageAllowedToDelete;

	@Value("${ageAllowedToAdd}")
	private int ageAllowedToAdd;

	public UserEntity addUser(UserDtoForCreate user) {
		if (user != null) {
			if (user.getFirstName() != null) {
				if (user.getLastName() != null) {
					if (user.getAge() > ageAllowedToAdd) {
						SubscriptionEntity subscriptionFound = subscriptionRepository
								.getSubscriptionById(user.getSubscription());
						UserEntity userToAdd = UserConverter.toEntityForCreate(user, subscriptionFound);

						userRepository.addUser(userToAdd);
						return userToAdd;
					} else {
						System.out.println("Registration not allowed because minimal age is " + ageAllowedToAdd
								+ " but user to add age is " + user.getAge());
						throw new CustomUserException("Could not register user");
					}
				} else {
					System.out.println("Last name is mandatory");
					throw new CustomUserException("Last name is mandatory");

				}
			} else {
				System.out.println("First name is mandatory");
				throw new CustomUserException("First name is mandatory");
			}
		}
		return null;
	}

	public void deleteUser(long id) {
		UserEntity user = userRepository.getUserById(id);
		if (user != null) {
			if (user.getSubscription() == null || !user.getSubscription().isActive()) {
				if (user.getAge() > ageAllowedToDelete) {
					userRepository.deleteUser(user);

				} else {
					System.out.println("Could not delete user, age allowed to delete id " + ageAllowedToDelete
							+ " but user age id " + user.getAge());
					throw new CustomUserException(id);
				}

			} else {
				System.out.println("Could not delete user because has an active subscription");
				throw new CustomUserException(id);
			}

		} else {
			System.out.println("User not found");
			throw new CustomUserException(id);
		}
	}
	public void addUserWithException(UserEntity user) {
	
		userRepository.addUser(user);
		throw new RuntimeException();
	}
	
	public void testTransaction() {
		SubscriptionEntity subEntity=new SubscriptionEntity();
		subEntity.setActive(true);
		subEntity.setName("TestTransaction");
		subscriptionRepository.addSubscription(subEntity);
		UserEntity userEntity=new UserEntity();
		userEntity.setFirstName("test");
		userEntity.setAge(20);
		userEntity.setLastName("test");
		
		addUserWithException(userEntity);
	}

}
