package com.ikubinfo.reservation.service;

import com.ikubinfo.reservation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User addUser(User user);
    boolean existsUser(User user);
    List<User> getAll();
}
