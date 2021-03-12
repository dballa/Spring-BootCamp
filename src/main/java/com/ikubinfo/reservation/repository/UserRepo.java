package com.ikubinfo.reservation.repository;

import com.ikubinfo.reservation.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserRepo {
    List<User> getAll();
    User addUser(User user);
    boolean existsUser(String email);
}
