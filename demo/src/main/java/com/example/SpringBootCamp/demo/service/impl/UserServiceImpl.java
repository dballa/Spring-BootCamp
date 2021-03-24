package com.example.SpringBootCamp.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.exceptions.CustomUserException;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Value("${ageAllowedToDelete}")
	private int ageAllowedToDelete;

	@Value("${ageAllowedToAdd}")
	private int ageAllowedToAdd;

	public UserEntity addUser(UserEntity user) {
		if (user != null) {
			if (user.getFirstName() != null) {
				if (user.getLastName() != null) {
					if (user.getAge() > ageAllowedToAdd) {
						userRepository.addUser(user);
						return user;
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

}
