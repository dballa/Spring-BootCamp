package com.ikubinfo.seanca11.usermanagement.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.seanca11.usermanagement.model.User;
import com.ikubinfo.seanca11.usermanagement.service.UserService;
import com.ikubinfo.seanca11.usermanagement.web.request.UserCreateRequest;
import com.ikubinfo.seanca11.usermanagement.web.request.UserUpdateModel;

@RestController
@RequestMapping("/user")
public class UserResource {

	private UserService userService;

	public UserResource(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@RequestBody UserCreateRequest request) {

		return userService
				.addUser(new User(request.getFirstName(), request.getLastName(), request.getAge(), request.getEmail()));

	}

	@PutMapping
	public User updateUser(@RequestBody UserUpdateModel request) {

		return userService.updateUser(
				new User(request.getFirstName(), request.getLastName(), request.getAge(), request.getEmail()));

	}

	@DeleteMapping
	@RequestMapping("/{email}")
	public void deleteUser(@PathVariable String email) {

		userService.delete(email);
	}

	@GetMapping
	public List<User> getAllUser() {
		return userService.getAll();
	}

	@GetMapping
	@RequestMapping("/{email}")
	public User getUserByEmail(@PathVariable String email) {

		return userService.findUser(email);
	}

}
