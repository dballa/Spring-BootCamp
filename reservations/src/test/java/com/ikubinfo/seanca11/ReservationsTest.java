package com.ikubinfo.seanca11;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;
import com.ikubinfo.seanca11.usermanagement.repository.ReservationRepository;
import com.ikubinfo.seanca11.usermanagement.repository.impl.ReservationsRepositoryImpl;
import com.ikubinfo.seanca11.usermanagement.service.ReservationService;
import com.ikubinfo.seanca11.usermanagement.service.impl.ReservationServiceImpl;

class ReservationsTest {


	static ReservationRepository reservationsRepo ;
    static ReservationService reservationsService ;
    static Reservations reservations1 ;
    static Reservations reservations2 ;
    
	private static Services serviceName1;
	private static Users username1;
	private static Users username2;
	private static Services serviceName2;
    
    
    @BeforeAll
    static void init(){
    	reservationsRepo = mock(ReservationsRepositoryImpl.class);
    	reservationsService = mock(ReservationServiceImpl.class);
    	LocalDateTime startDate1= LocalDateTime.of(2021,03,13,14,00);
    	LocalDateTime endDate1= LocalDateTime.of(2021,03,13,14,40);
        
		reservations1 = new Reservations(username1, serviceName1, startDate1 , endDate1);
		
		
       
		reservations2 = new Reservations(username2, serviceName2, LocalDateTime.of(2021,03,13,15,30) , LocalDateTime.of(2021,03,13,16,10));
        
    }
    
    @Test
    void ReservationManagmentTestService(){
        when(reservationsService.management(reservations1)).thenReturn(reservations1);
        assertNotNull(reservationsService.management(reservations1));
        
        when(reservationsService.management(reservations2)).thenReturn(reservations2);
        assertNotNull(reservationsService.management(reservations2));
    }
    @Test
    void saveReservationsTestRepo(){
        when(reservationsRepo.save(reservations1)).thenReturn(reservations1);
        assertNotNull(reservationsRepo.save(reservations1));
        
        when(reservationsRepo.save(reservations2)).thenReturn(reservations2);
        assertNotNull(reservationsRepo.save(reservations2));
    }

	

}
