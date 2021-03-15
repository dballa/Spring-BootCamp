package com.academy.monika.service;

import com.academy.monika.service.model.OfferedService;
import com.academy.monika.service.model.Reservation;
import com.academy.monika.service.model.User;
import com.academy.monika.service.repository.impl.ReservationRepository;
import com.academy.monika.service.repository.impl.ServiceRepository;
import com.academy.monika.service.repository.impl.UserRepository;
import com.academy.monika.service.service.impl.ReservationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReservationTest {


    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private ServiceRepository serviceRepository;
    private ReservationServiceImpl reservationService;

    @BeforeEach
    public void initializeBeforeAllTestMethods() {
        reservationRepository = Mockito.mock(ReservationRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        serviceRepository = Mockito.mock(ServiceRepository.class);
        reservationService = new ReservationServiceImpl(reservationRepository, userRepository, serviceRepository);
    }

    @Test
    public void reservationSuccessfullyCreationTest() {
        OfferedService service = new OfferedService();
        service.setId("SERVICE0001");
        service.setPrice(15);
        service.setName("Prerje Flokesh");
        User user = new User();
        user.setUsername("monika");
        user.setFirstName("Monika");
        user.setLastName("Papa");
        user.setPhone("482526");
        user.setDateOfBirth(LocalDateTime.of(1990, Month.FEBRUARY, 02, 00, 00));
        Reservation reservation = new Reservation();
        reservation.setServiceId(service.getId());
        reservation.setUserUuid(user.getUsername());
        reservation.setStartTime(LocalDateTime.of(2021, Month.FEBRUARY, 12, 10, 30));
        reservation.setEndTime(LocalDateTime.of(2021, Month.FEBRUARY, 12, 11, 30));
        reservation.setId("RESERVC0001");
        when(serviceRepository.serviceExists(service.getId())).thenReturn(true);
        when(userRepository.userExists(user.getUsername())).thenReturn(true);
        when(reservationRepository.create(reservation)).thenReturn(reservation);
        assertEquals(reservation, reservationService.add(reservation));
    }
}
