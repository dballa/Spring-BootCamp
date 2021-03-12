package com.reservation.reservationapplication.repository;

import com.reservation.reservationapplication.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    User findByEmail(String email);
    User findByUsername(String username);
    List<User> getUsers();

}
