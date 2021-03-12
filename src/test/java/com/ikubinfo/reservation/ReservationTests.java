package com.ikubinfo.reservation;

import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import com.ikubinfo.reservation.service.impl.ReservationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReservationTests {
    @Test
    void testValidations(){
        ReservationRepoImpl impl = new ReservationRepoImpl();
        List<User> users = new ArrayList<>();
        List<ShopService> shopServiceList = new ArrayList<>();

        users.add(new User("joan","janku","email"));
        users.add(new User("john","doe","email2"));
        users.add(new User("Jim","Carry","emailJIm"));

        shopServiceList.add(new ShopService("barber",2.0,"blabalbl"));
        shopServiceList.add(new ShopService("mechanic",2.0,"blabalbl"));
        shopServiceList.add(new ShopService("medic",20.0,"blabalbl"));
        //user existance tests
        assertTrue(impl.existsUser(users,new Reservation("barber","joanjanku",
                LocalDateTime.of(2021,3,11,16,35),
                LocalDateTime.of(2021,3,11,16,35))));
        assertFalse( impl.existsUser(users,new Reservation("barber","xhim",
                LocalDateTime.of(2021,3,11,16,35),
                LocalDateTime.of(2021,3,11,16,35))));
        // service existance tests
        assertTrue(impl.existsService(shopServiceList,new Reservation("barber","xhim",
                LocalDateTime.of(2021,3,11,16,35),
                LocalDateTime.of(2021,3,11,16,35))));
        assertFalse(impl.existsService(shopServiceList,new Reservation("mjek","xhim",
                LocalDateTime.of(2021,3,11,16,35),
                LocalDateTime.of(2021,3,11,16,35))));
    }
}
