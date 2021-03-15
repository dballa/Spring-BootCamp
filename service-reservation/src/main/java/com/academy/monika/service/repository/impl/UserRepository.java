package com.academy.monika.service.repository.impl;

import com.academy.monika.service.model.User;
import com.academy.monika.service.repository.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements CustomRepository<User> {
    List<User> userList = new ArrayList<>();

    @Override
    public User get(String uuid) {
        for (User user : userList) {
            if (uuid.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public User create(User obj) {
        userList.add(obj);
        return obj;
    }

    @Override
    public User update(String uuid, User updatedObj) {
        for (User user : userList) {
            if (uuid.equals(user.getUsername())) {
                user.setFirstName(updatedObj.getFirstName());
                user.setLastName(updatedObj.getLastName());
                user.setPhone(updatedObj.getPhone());
                user.setDateOfBirth(updatedObj.getDateOfBirth());
                return user;
            }
        }
        return null;
    }

    @Override
    public User delete(String uuid) {
        for (User user : userList) {
            if (uuid.equals(user.getUsername())) {
                userList.remove(user);
            }
        }
        return null;
    }

    public Boolean userExists(String uuid) {
        for (User user : userList) {
            if (uuid.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
