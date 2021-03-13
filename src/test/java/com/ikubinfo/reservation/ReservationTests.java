package com.ikubinfo.reservation;

import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import com.ikubinfo.reservation.repository.UserRepo;
import com.ikubinfo.reservation.repository.impl.ReservationRepoImpl;
import com.ikubinfo.reservation.repository.impl.UserRepoImpl;
import com.ikubinfo.reservation.service.ReservationService;
import com.ikubinfo.reservation.service.UserService;
import com.ikubinfo.reservation.service.impl.ReservationServiceImpl;
import com.ikubinfo.reservation.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;


public class ReservationTests {
    static ReservationRepoImpl reservationRepo ;
    static ReservationService reservationService ;
    static User user1 ;
    static ShopService shopService ;
    static Reservation reservation;
    static LocalDateTime date;
    @BeforeAll
    static void initialize(){
        reservationRepo = mock(ReservationRepoImpl.class);
        reservationService = mock(ReservationServiceImpl.class);
        user1 = new User();
        user1.setEmail("email");
        user1.setName("Joan");
        user1.setLastname("Janku");
        date = LocalDateTime.of(2021,10,5,5,2);
        shopService = new ShopService("Barber",200.0,"lala");
        reservation = new Reservation("Barber","JoanJanku",date,date );
    }

    @Test
    void testReservationService(){
        when(reservationService.addReservation(reservation)).thenReturn(reservation);
        assertNotNull(reservationService.addReservation(reservation));
        assertNull(reservationService.addReservation((new Reservation("Barber","JoanJanku",date,date ))));
    }
}
