package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.UserManagementException;
import com.reservation.reservationapplication.model.User;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.reservation.reservationapplication.repository.UserRepository;
import com.reservation.reservationapplication.repository.implementations.UserRepositoryImp;
import com.reservation.reservationapplication.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImpTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void initializeBeforeAllTestMethods() {
        userRepository = Mockito.mock(UserRepositoryImp.class);
        userService = new UserServiceImp(userRepository);
    }

    @Test
    void successfulCreateUserTest() {

        User user = new User("Dhimitrios", "Duka", 21, "dhimitrios.duka@fti.edu.al");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.create(user));

    }

    @Test
    void unsuccessfulCreateUserTest() {

        User firstUser = new User("Dhimitrios", "Duka", 21, "dhimitrios.duka@fti.edu.al");
        User secondUser = new User("Mico", "Duka", 21, "dhimitrios.duka@fti.edu.al");
        when(userRepository.findByEmail(firstUser.getEmail())).thenReturn(firstUser);

        Exception duplicateUserException = assertThrows(UserManagementException.class, ()  -> userService.create(secondUser));
        assertEquals(duplicateUserException.getMessage(), "A user with this email already exists!");

    }
}