package controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import converter.UserConverter;
import dto.UserDto;
import dto.UserFilter;
import dto.UserToCreateDto;
import dto.UserToUpdateDto;
import io.swagger.annotations.ApiOperation;
import service.UserServiceInterface;

@RestController
public class UserController {

	@Autowired
	UserServiceInterface userService;

	@GetMapping(value = "/allUsers")
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam(required=false) String name ){
		List<UserDto>toReturn=new ArrayList<UserDto>();
		userService.getAllUsers(name).forEach(entity->toReturn.add(UserConverter.toDto(entity)));
		return new ResponseEntity<List<UserDto>>(toReturn,HttpStatus.OK) ;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam(required = false) String name,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) Integer age,
			@RequestParam(required = false) String sortBy, @RequestParam(required = false) String order) {
		List<UserDto> toReturn = new ArrayList<UserDto>();
		UserFilter filter = new UserFilter(name, lastName, age, sortBy, order);
		userService.getUsers(filter).forEach(entity -> toReturn.add(UserConverter.toDto(entity)));
		return new ResponseEntity<List<UserDto>>(toReturn, HttpStatus.OK);
	}
	
	@ApiOperation(value="Add a new user")
	@PostMapping("/users")
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserToCreateDto user) {
		
		
		return new ResponseEntity<>(UserConverter.toDto(userService.insertUser(user)),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/findUser/{id}")
	public UserDto findUser(@PathVariable int id) {
		return UserConverter.toDto(userService.findUser(id));
	}
	
	@PutMapping(value = "/updateUser")
	public UserDto updateUser(@RequestBody UserToUpdateDto user) {
		return UserConverter.toDto(userService.updateUser(user));
	
	}
	
	
	@DeleteMapping(value = "/usersSoft/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUserSoft(@PathVariable int id) {
		userService.deleteUserSoft(id);

	}
	
	@DeleteMapping(value = "/usersHard/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUserHard(@PathVariable int id) {
		userService.deleteUserHard(id);
		
	}
	
	@GetMapping("/testRestTemplate")
	public void testRest(){
		userService.testRest();
	}
}