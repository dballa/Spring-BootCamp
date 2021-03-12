package com.ikubinfo.reservation;

import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import com.ikubinfo.reservation.repository.ShopServiceRepo;
import com.ikubinfo.reservation.repository.UserRepo;
import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import com.ikubinfo.reservation.repository.impl.ShopServiceRepoImpl;
import com.ikubinfo.reservation.repository.impl.UserRepoImpl;
import com.ikubinfo.reservation.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserTests {
    @Test
    void userExistsTest(){
        UserRepoImpl userRepo = new UserRepoImpl();
        userRepo.userList.add(new User("John","Doe","email"));
        userRepo.userList.add(new User("John","Doe","email2"));

        assertTrue(userRepo.existsUser("email"));
        assertFalse(userRepo.existsUser("email4"));
    }
}
