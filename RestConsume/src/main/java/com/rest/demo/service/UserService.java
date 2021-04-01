package com.rest.demo.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.converter.UserConverter;
import com.rest.demo.dto.UserDtoCreate;
import com.rest.demo.dto.WeatherDto;
import com.rest.demo.entity.LocationEntity;
import com.rest.demo.entity.UserEntity;
import com.rest.demo.exceptions.MyException;
import com.rest.demo.repository.LocationRepository;
import com.rest.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

	UserRepository userRepo;
	LocationRepository locRepo;
	WeatherService weatherService;

	private static final String NO_USER = "No User on given id !";
	@Autowired
	public UserService(UserRepository userRepo, LocationRepository locRepo, WeatherService weatherService) {
		super();
		this.userRepo = userRepo;
		this.locRepo = locRepo;
		this.weatherService = weatherService;
	}

	//RETURN THE NEW USER
	public UserEntity insertUsers(UserDtoCreate user) {
		if (user != null) {
			LocationEntity location = locRepo.getLocationById(user.getLocation());
			if (location != null) {
				UserEntity userToAdd = UserConverter.toEntityForCreate(user, location);
				userRepo.insertUser(userToAdd);
				return userToAdd;
			} else {
				throw new MyException("No Location with given id !");
			}
		} else {
			throw new MyException("User body is empty !");
		}
	}

	//RETURN UPDATED USER
	public UserEntity updateUsers(UserDtoCreate user, int id) {
		if (user != null) {
			UserEntity userToAdd = userRepo.getUserById(id);
			LocationEntity location = locRepo.getLocationById(user.getLocation());
			userToAdd.setUsername(user.getUsername());
			userToAdd.setPassword(user.getPassword());
			userToAdd.setLocation(location);
			userRepo.updateUser(userToAdd);
			return userToAdd;
		} else {
			throw new MyException("User body is empty !");
		}
	}

	//RETURN THE DELETED USER
	public UserEntity deleteUsers(int id) {
		UserEntity userToDelete = userRepo.getUserById(id);
		if (userToDelete != null) {
			userRepo.deleteUser(userToDelete);
			return userToDelete;
		}
		throw new MyException(NO_USER);
	}

	//RETURN WEATHER DATA FOR SPECIFIC USER
	public WeatherDto getUserWeather(int id) {
		UserEntity user = userRepo.getUserById(id);
		if(user!=null) {
			LocationEntity location = user.getLocation();
			return weatherService.getWeatherByCity(location.getCity());
		}else {
			throw new MyException(NO_USER);
		}
	}

	//RETURN USER BY ID IF EXIST
	public UserEntity getUserById(int id) {
		UserEntity user = userRepo.getUserById(id);
		if(user!=null) {
			return user;
		}else {
			throw new MyException(NO_USER);
		}
	}

	public Iterable<UserEntity> showUsersByAndOrdered(String city, Boolean sortByName) {
		if(city!=null && !city.isEmpty()) {
			if(sortByName) {
				LocationEntity location = locRepo.getLocationByCity(city);
				return userRepo.getFilteredAndOrdered(location);
			}else {
				LocationEntity location = locRepo.getLocationByCity(city);
				return userRepo.getFilterByCity(location);
			}
		}else {
			if(sortByName) {
				return userRepo.getUsersOrderedBy();
			}else{
				return userRepo.getUsers();
			}
		}
	}

}
