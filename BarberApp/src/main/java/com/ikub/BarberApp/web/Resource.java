package com.ikub.BarberApp.web;


import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.User;
import com.ikub.BarberApp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Resource {
    UserService userService;

    public Resource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("add")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping("book")
    public Reservation book(@RequestBody Reservation reservation){
    return   userService.addReservation(reservation);
    }
}
