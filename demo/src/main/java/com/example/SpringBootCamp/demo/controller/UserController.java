package com.example.SpringBootCamp.demo.controller;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.dto.UserFilter;
import com.example.SpringBootCamp.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Add a new user")
    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user) {

        return new ResponseEntity<>(UserConverter.toDto(userService.addUser(user)), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(required = false) String firstName,
                                                  @RequestParam(required = false) String lastName, @RequestParam(required = false) Integer age,
                                                  @RequestParam(required = false) String role,
                                                  @RequestParam(required = false) String sortBy, @RequestParam(required = false) String order) {
        List<UserDto> toReturn = new ArrayList<UserDto>();
        UserFilter filter = new UserFilter(firstName, lastName, age,role, sortBy, order);
        userService.getUsers(filter).forEach(entity -> toReturn.add(UserConverter.toDto(entity)));
        return new ResponseEntity<List<UserDto>>(toReturn, HttpStatus.OK);

    }
    @GetMapping("/getallusers")
    public  ResponseEntity<List<UserDto>> getallUsers(){
        List<UserDto> toReturn = new ArrayList<UserDto>();
        userService.getAllUsers().forEach(entity -> toReturn.add(UserConverter.toDto(entity)));
        return new ResponseEntity<List<UserDto>>(toReturn, HttpStatus.OK);
    }


    @GetMapping("/testRestTemplate")
    public void testRest() {
        userService.testRest();
    }
}
