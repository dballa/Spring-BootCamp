package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.FacilityServiceManagementException;
import com.reservation.reservationapplication.exceptions.UserManagementException;
import com.reservation.reservationapplication.model.Facility;
import com.reservation.reservationapplication.model.User;
import com.reservation.reservationapplication.repository.FacilityRepository;
import com.reservation.reservationapplication.repository.UserRepository;
import com.reservation.reservationapplication.repository.implementations.FacilityRepositoryImp;
import com.reservation.reservationapplication.repository.implementations.UserRepositoryImp;
import com.reservation.reservationapplication.service.FacilityService;
import com.reservation.reservationapplication.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FacilityServiceImpTest {

    private FacilityService facilityService;
    private FacilityRepository facilityRepository;

    @BeforeEach
    public void initializeBeforeAllTestMethods() {
        facilityRepository = Mockito.mock(FacilityRepositoryImp.class);
        facilityService = new FacilityServiceImp(facilityRepository);
    }


    @Test
    void successfulCreateFacilityTest() {

        Facility facility = new Facility();
        facility.setName("Haircut");
        facility.setDescription("Great haircut!");
        facility.setPrice(12.5);

        when(facilityRepository.save(facility)).thenReturn(facility);
        assertEquals(facility, facilityService.create(facility));

    }

    @Test
    void unsuccessfulCreateFacilityTest() {

        Facility facilityOne = new Facility();
        facilityOne.setName("Haircut");
        facilityOne.setDescription("Great haircut!");
        facilityOne.setPrice(12.5);

        Facility facilityTwo = new Facility();
        facilityTwo.setName("Haircut");
        facilityTwo.setDescription("Great haircut!");
        facilityTwo.setPrice(12.5);

        when(facilityRepository.findByName(facilityOne.getName())).thenReturn(facilityOne);

        Exception duplicateFacilityException = assertThrows(FacilityServiceManagementException.class, ()  -> facilityService.create(facilityTwo));
        assertEquals(duplicateFacilityException.getMessage(), "Facility already exists!");

    }
}