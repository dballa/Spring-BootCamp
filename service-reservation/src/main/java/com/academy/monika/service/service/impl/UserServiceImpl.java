package com.academy.monika.service.service.impl;

import com.academy.monika.service.customexception.CustomException;
import com.academy.monika.service.model.User;
import com.academy.monika.service.repository.impl.UserRepository;
import com.academy.monika.service.service.CustomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements CustomService<User> {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(String uuid) {
        if (!userRepository.userExists(uuid)) {
            throw new CustomException("User not found!");
        }
        return userRepository.get(uuid);
    }

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }

    @Override
    public User add(User obj) {
        if (userRepository.userExists(obj.getUsername())) {
            throw new CustomException("This user already exists!");
        }
        return userRepository.create(obj);
    }

    @Override
    public User update(String uuid, User updatedObj) {
        if (!userRepository.userExists(updatedObj.getUsername())) {
            throw new CustomException("User not found!");
        }
        return userRepository.update(uuid, updatedObj);
    }

    @Override
    public User delete(String uuid) {
        if (!userRepository.userExists(uuid)) {
            throw new CustomException("User not found!");
        }
        return userRepository.delete(uuid);
    }

}
