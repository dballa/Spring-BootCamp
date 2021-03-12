package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.UserManagementException;
import com.reservation.reservationapplication.model.User;
import com.reservation.reservationapplication.repository.UserRepository;
import com.reservation.reservationapplication.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if(!Objects.isNull(userRepository.findByEmail(user.getEmail()))) {
            throw new UserManagementException("A user with this email already exists!");
        }else {
            return userRepository.save(user);
        }
    }

}
