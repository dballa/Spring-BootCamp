package com.example.SpringBootCamp.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.ResponseTestExternalAPI;
import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.entity.SubscriptionEntity;
import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.exceptions.CustomUserException;
import com.example.SpringBootCamp.demo.repository.SubscriptionRepository;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	RestTemplate restTemplate;

	@Value("${ageAllowedToDelete}")
	private int ageAllowedToDelete;

	@Value("${ageAllowedToAdd}")
	private int ageAllowedToAdd;
	
	private String URL="https://jsonplaceholder.typicode.com/todos/1";

	public UserEntity addUser(UserDtoForCreate user) {
		if (user != null) {

			if (user.getAge() > ageAllowedToAdd) {
				SubscriptionEntity subscriptionFound = subscriptionRepository
						.getSubscriptionById(user.getSubscription());
				UserEntity userToAdd = UserConverter.toEntityForCreate(user, subscriptionFound);

				userRepository.addUser(userToAdd);
				return userToAdd;
			} else {

				throw new CustomUserException("Registration not allowed because minimal age is " + ageAllowedToAdd
						+ " but user to add age is " + user.getAge());
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
					throw new CustomUserException("Could not delete user, age allowed to delete id " + ageAllowedToDelete
							+ " but user age id " + user.getAge());
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
		SubscriptionEntity subEntity = new SubscriptionEntity();
		subEntity.setActive(true);
		subEntity.setName("TestTransaction");
		subscriptionRepository.addSubscription(subEntity);
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("test");
		userEntity.setAge(20);
		userEntity.setLastName("test");

		addUserWithException(userEntity);
	}

	@Override
	public List<UserEntity> getUsers(String name) {
		if (name != null && !name.isEmpty())

			return userRepository.getFilterByName(name);
		else
			return userRepository.getAllUsers();
	}

	@Override
	public void testRest() {
		//HttpEntity<Re>
		ResponseEntity<ResponseTestExternalAPI> response=restTemplate.exchange(URL, HttpMethod.GET, null, ResponseTestExternalAPI.class);
		
		ResponseTestExternalAPI a=response.getBody();
		
		System.out.println(a);
	}

}
