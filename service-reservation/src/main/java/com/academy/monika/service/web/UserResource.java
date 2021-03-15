package com.academy.monika.service.web;

import com.academy.monika.service.model.User;
import com.academy.monika.service.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {

    private UserServiceImpl userService;

    public UserResource(UserServiceImpl userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getList();
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public User getUser(@PathVariable String email) {
        return userService.get(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.add(user);
    }


    @RequestMapping(value = "/{email}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        return userService.update(email, user);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable String email) {
        return userService.delete(email);
    }
}
