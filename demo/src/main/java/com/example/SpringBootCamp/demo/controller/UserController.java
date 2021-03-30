package com.example.SpringBootCamp.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.dto.UserDtoForCreate;
import com.example.SpringBootCamp.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	UserService userSevice;

	@DeleteMapping("/users/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable long id) {
		userSevice.deleteUser(id);

	}

	@ApiOperation(value="Add a new user")
	@PostMapping("/users")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDtoForCreate user) {
		
		
		return new ResponseEntity<>(UserConverter.toDto(userSevice.addUser(user)),HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam(required=false) String name ){
		List<UserDto>toReturn=new ArrayList<UserDto>();
		userSevice.getUsers(name).forEach(entity->toReturn.add(UserConverter.toDto(entity)));
		return new ResponseEntity<List<UserDto>>(toReturn,HttpStatus.OK) ;
		
	}
	
	
	
	
	@PostMapping("/testTransaction")
	public void testTransaction() {
		userSevice.testTransaction();
	}

	@GetMapping("/testRestTemplate")
	public void testRest(){
		userSevice.testRest();
	}

}
