package com.academy.monika.service;

import com.academy.monika.service.model.User;
import com.academy.monika.service.repository.impl.UserRepository;
import com.academy.monika.service.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserTest {
    private UserServiceImpl userService;
    private UserRepository userRepository;

    @BeforeEach
    public void beforeEachMethod() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void userCreatedSuccessfullyTest() {

        User user = new User();
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setUsername("username");
        user.setPhone("1584562");
        when(userRepository.create(user)).thenReturn(user);
        assertEquals(user, userService.add(user));
    }

}
