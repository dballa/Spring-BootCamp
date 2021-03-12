package com.reservation.reservationapplication.repository.implementations;

import com.reservation.reservationapplication.model.User;
import com.reservation.reservationapplication.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final List<User> users;

    public UserRepositoryImp() {
        users = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }
}
