package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import converter.UserConverter;
import dto.UserDto;
import dto.UserToCreateDto;
import dto.UserToUpdateDto;
import entity.UserEntity;
import service.UserServiceInterface;

@RestController
public class UserController {

	@Autowired
	UserServiceInterface userService;

	@GetMapping(value = "/AllUsers")
	public List<UserDto> getAllUsers() {
			
			List<UserDto> users = new ArrayList<>(); 
			for(UserEntity user : userService. getAllUsers()) {
				users.add(UserConverter.toDto(user));
			}
			return users;
	}
	
	@PostMapping(value = "/createUser")
	public UserDto createUser(@RequestBody UserToCreateDto user) {
		
		return UserConverter.toDto(userService.insertUser(user));
	
	}
	
	@GetMapping(value = "/findUser/{id}")
	public UserDto findUser(@PathVariable int id) {
		return UserConverter.toDto(userService.findUser(id));
	}
	
	@PutMapping(value = "/updateUser")
	public UserDto updateUser(@RequestBody UserToUpdateDto user) {
		return UserConverter.toDto(userService.updateUser(user));
	
	}
	
	
	@DeleteMapping(value = "/deleteUserByIdSoft/{id}")
	public void deleteUserSoft(@PathVariable int id) {
		userService.deleteUserSoft(id);

	}
	
	@DeleteMapping(value = "/deleteUserByIdHard/{id}")
	public void deleteUserHard(@PathVariable int id) {
		userService.deleteUserHard(id);
		
	}
}