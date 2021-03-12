package com.ikubinfo.reservation.repository.impl;

import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.UserRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepoImpl implements UserRepo {
    public  List<User> userList = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public User addUser(User user) {
         userList.add(user);
         return user;
    }

    @Override
    public boolean existsUser(String email) {
        for (User user : userList){
            if (user.getEmail().compareTo(email)==0){
                return true;
            }
        }
        return false;
    }
}
