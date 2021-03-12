package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.FacilityServiceManagementException;
import com.reservation.reservationapplication.exceptions.ReservationManagementException;
import com.reservation.reservationapplication.exceptions.UserManagementException;
import com.reservation.reservationapplication.model.Facility;
import com.reservation.reservationapplication.model.Reservation;
import com.reservation.reservationapplication.model.User;
import com.reservation.reservationapplication.repository.FacilityRepository;
import com.reservation.reservationapplication.repository.ReservationRepository;
import com.reservation.reservationapplication.repository.UserRepository;
import com.reservation.reservationapplication.repository.implementations.FacilityRepositoryImp;
import com.reservation.reservationapplication.service.FacilityService;
import com.reservation.reservationapplication.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReservationServiceImpTest {


    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private FacilityRepository facilityRepository;
    private ReservationService reservationService;
    private User user;
    private Facility facility;
    private Reservation reservation;

    @BeforeEach
    public void initializeBeforeAllTestMethods() {
        reservationRepository = Mockito.mock(ReservationRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
        facilityRepository = Mockito.mock(FacilityRepository.class);

        reservationService = new ReservationServiceImp(reservationRepository, userRepository, facilityRepository);

        user = new User("dhimitrios", "duka", 21, "dhimitrios.duka@fti.edu.al");

        facility = new Facility();
        facility.setName("Haircut");
        facility.setDescription("Description");
        facility.setPrice(12);

        reservation = new Reservation();
        reservation.setUsername(user.getUsername());
        reservation.setStart(LocalDateTime.of(2021, Month.MARCH, 12, 12, 0));
        reservation.setEnd(LocalDateTime.of(2021, Month.MARCH, 12, 13, 0));
        reservation.setFacility(facility.getName());

    }

    @Test
    void successfulCreateReservation() {

        when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
        when(facilityRepository.findByName(facility.getName())).thenReturn(facility);
        when(reservationRepository.exists(reservation)).thenReturn(false);
        when(reservationRepository.availableReservation(reservation)).thenReturn(true);
        when(reservationRepository.create(reservation)).thenReturn(reservation);

        assertEquals(reservation, reservationService.create(reservation));

    }

    @Test
    void unsuccessfulCreateReservationUsernameDoesntExist() {

        when(userRepository.findByUsername(reservation.getUsername())).thenReturn(null);
        when(facilityRepository.findByName(facility.getName())).thenReturn(facility);
        when(reservationRepository.exists(reservation)).thenReturn(false);
        when(reservationRepository.availableReservation(reservation)).thenReturn(true);
        when(reservationRepository.create(reservation)).thenReturn(reservation);

        Exception userDoesntExistException = assertThrows(UserManagementException.class, ()  -> reservationService.create(reservation));
        assertEquals(userDoesntExistException.getMessage(), "Username doesn't exist!");

    }

    @Test
    void unsuccessfulCreateReservationFacilityDoesntExist() {

        when(userRepository.findByUsername(reservation.getUsername())).thenReturn(user);
        when(facilityRepository.findByName(facility.getName())).thenReturn(null);
        when(reservationRepository.exists(reservation)).thenReturn(false);
        when(reservationRepository.availableReservation(reservation)).thenReturn(true);
        when(reservationRepository.create(reservation)).thenReturn(reservation);

        Exception facilityDoesntExistException = assertThrows(FacilityServiceManagementException.class, ()  -> reservationService.create(reservation));
        assertEquals(facilityDoesntExistException.getMessage(), "Facility doesn't exist!");

    }

    @Test
    void unsuccessfulCreateReservationWhenReservationExists() {

        when(userRepository.findByUsername(reservation.getUsername())).thenReturn(user);
        when(facilityRepository.findByName(facility.getName())).thenReturn(facility);
        when(reservationRepository.exists(reservation)).thenReturn(true);
        when(reservationRepository.availableReservation(reservation)).thenReturn(true);
        when(reservationRepository.create(reservation)).thenReturn(reservation);

        Exception reservationExistException = assertThrows(ReservationManagementException.class, ()  -> reservationService.create(reservation));
        assertEquals(reservationExistException.getMessage(), "Reservation not available!");

    }

    @Test
    void unsuccessfulCreateReservationWhenReservationIsNotAvailable() {

        when(userRepository.findByUsername(reservation.getUsername())).thenReturn(user);
        when(facilityRepository.findByName(facility.getName())).thenReturn(facility);
        when(reservationRepository.exists(reservation)).thenReturn(true);
        when(reservationRepository.availableReservation(reservation)).thenReturn(false);
        when(reservationRepository.create(reservation)).thenReturn(reservation);

        Exception reservationExistException = assertThrows(ReservationManagementException.class, ()  -> reservationService.create(reservation));
        assertEquals(reservationExistException.getMessage(), "Reservation not available!");

    }

    @Test
    void getAllReservationsOfFacility() {

        Reservation secondReservation = new Reservation();
        secondReservation.setUsername(user.getUsername());
        secondReservation.setStart(LocalDateTime.of(2021, Month.MARCH, 15, 12, 0));
        secondReservation.setEnd(LocalDateTime.of(2021, Month.MARCH, 15, 13, 0));
        secondReservation.setFacility(facility.getName());
        List<Reservation> reservations = Arrays.asList(reservation, secondReservation);

        List<Reservation> reservationOfFacilities = new ArrayList<>();
        for(Reservation reservation : reservations) {
            if(reservation.getFacility().equals("Haircut")) {
                reservationOfFacilities.add(reservation);
            }
        }

        when(reservationRepository.getAllReservationsOfFacility("Haircut")).thenReturn(reservationOfFacilities);
        assertEquals(reservationOfFacilities, reservationService.getAllReservationsOfFacility("Haircut"));

    }
}