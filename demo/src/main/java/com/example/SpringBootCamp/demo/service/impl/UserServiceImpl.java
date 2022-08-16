package com.example.SpringBootCamp.demo.service.impl;

import com.example.SpringBootCamp.demo.converter.UserConverter;
import com.example.SpringBootCamp.demo.dto.ResponseTestExternalAPI;
import com.example.SpringBootCamp.demo.dto.UserDto;
import com.example.SpringBootCamp.demo.dto.UserFilter;
import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.exceptions.UserException;
import com.example.SpringBootCamp.demo.repository.MembershipInfoRepository;
import com.example.SpringBootCamp.demo.repository.UserRepository;
import com.example.SpringBootCamp.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MembershipInfoRepository membershipInfoRepository;
    private String URL = "https://jsonplaceholder.typicode.com/todos/1";
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public UserEntity addUser(UserDto user) {
        logger.info("Adding user {}", user);
        if (user != null) {
            UserEntity addedUser = UserConverter.toEntity(user);
            userRepository.addUser(addedUser);
            logger.info("User added");
            return addedUser;}
        else
        { logger.warn("Something went wrong");}

        return null;
    }

    @Override
    public List<UserEntity> getUsers(UserFilter filter) {
        logger.info("Filtring users with filter {}", filter);
        return userRepository.getUsers(filter);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity user=userRepository.getUserById(id);
        if (user!=null){
            userRepository.DeleteUser(user);


        }else {
            throw new UserException("User not found");
        }

    }

    @Override
    public UserEntity getUserById(Long id) {
        UserEntity user=userRepository.getUserById(id);
        if(user!=null){
            logger.info("User found!");
        } else {

        throw new UserException("User not found");
    }
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {

        return userRepository.getAllUsers();
    }


    @Override
    public void testRest() {

        ResponseEntity<ResponseTestExternalAPI> response = restTemplate.exchange(URL, HttpMethod.GET, null,
                ResponseTestExternalAPI.class);

        ResponseTestExternalAPI a = response.getBody();

        System.out.println(a);
    }
}
