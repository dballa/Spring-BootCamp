package com.ikubinfo.reservation.service.impl;

import com.ikubinfo.reservation.exceptions.UserManagementException;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.UserRepo;
import com.ikubinfo.reservation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo ;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo= userRepo;
    }

    @Override
    public User addUser(User user) {
        if (userRepo.existsUser(user.getEmail())){
            throw new UserManagementException("This user already exists");
        } else {
            return userRepo.addUser(user);
        }
    }

    @Override
    public boolean existsUser(User user) {
       return userRepo.existsUser(user.getEmail());
    }

    @Override
    public List<User> getAll(){
        return userRepo.getAll();
    }
}
