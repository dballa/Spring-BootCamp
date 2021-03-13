package com.ikubinfo.reservation;

import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import com.ikubinfo.reservation.repository.ShopServiceRepo;
import com.ikubinfo.reservation.repository.UserRepo;
import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import com.ikubinfo.reservation.repository.impl.ShopServiceRepoImpl;
import com.ikubinfo.reservation.repository.impl.UserRepoImpl;
import com.ikubinfo.reservation.service.UserService;
import com.ikubinfo.reservation.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserTests {
    static UserRepo userRepo ;
    static UserService userService ;
    static User user1 ;
    static User user2 ;
    @BeforeAll
    static void initialize(){
        userRepo = mock(UserRepoImpl.class);
        userService = mock(UserServiceImpl.class);
         user1 = new User();
        user1.setEmail("email");
        user1.setName("Joan");
        user1.setLastname("Janku");
    }
    @Test
    void userAddTestService(){
        when(userService.addUser(user1)).thenReturn(user1);
        assertNotNull(userService.addUser(user1));
    }
    @Test
    void userAddTestRepo(){
        when(userRepo.addUser(user1)).thenReturn(user1);
        assertNotNull(userRepo.addUser(user1));
    }
    @Test
    void userExistRepo(){
        when(userRepo.existsUser("email")).thenReturn(true);
        assertTrue(userRepo.existsUser("email"));
        assertFalse(userRepo.existsUser("falseTest"));
    }
    @Test
    void userExistService(){
        when(userService.existsUser(user1)).thenReturn(true);
        assertTrue(userService.existsUser(user1));
        assertFalse(userService.existsUser(user2));
    }
}
