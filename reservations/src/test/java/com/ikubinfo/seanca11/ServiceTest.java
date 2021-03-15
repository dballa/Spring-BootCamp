package com.ikubinfo.seanca11;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.repository.ReservationRepository;
import com.ikubinfo.seanca11.usermanagement.repository.impl.ReservationsRepositoryImpl;
import com.ikubinfo.seanca11.usermanagement.service.ReservationService;
import com.ikubinfo.seanca11.usermanagement.service.impl.ReservationServiceImpl;

class ServiceTest {

	    static ReservationRepository serviceRepo ;
	    static ReservationService serviceService ;
	    static List<Reservations> reservations;
	    static Services service1 ;
	    static Services service2 ;
	    
	    @BeforeAll
	    static void init(){
	    	serviceRepo = mock(ReservationsRepositoryImpl.class);
	    	serviceService = mock(ReservationServiceImpl.class);
	    	service1 = new Services("ServiceName1", "Description1", 25.5);
	    	
	    	service2 = new Services("ServiceName2", "Description2", 30.4);
	    	
	    }
	    
	    @Test
	    void addServiceTestService(){
	        when(serviceService.addService(service1)).thenReturn(service1);
	        assertNotNull(serviceService.addService(service1));
	        
	        when(serviceService.addService(service2)).thenReturn(service2);
	        assertNotNull(serviceService.addService(service2));
	    }
	    
	    @Test
	    void saveServicesTestRepo(){
	        when(serviceRepo.save(service1)).thenReturn(service1);
	        assertNotNull(serviceRepo.save(service1));
	        
	        when(serviceRepo.save(service2)).thenReturn(service2);
	        assertNotNull(serviceRepo.save(service2));
	        
	    }
	    @Test
	    void existServiceWithNameRepo(){
	        when(serviceRepo.existServiceWithName("ServiceName1")).thenReturn(true);
	        assertTrue(serviceRepo.existServiceWithName("ServiceName1"));
	        assertFalse(serviceRepo.existServiceWithName("falseName1"));
	        
	        when(serviceRepo.existServiceWithName("ServiceName2")).thenReturn(true);
	        assertTrue(serviceRepo.existServiceWithName("ServiceName2"));
	        assertFalse(serviceRepo.existServiceWithName("falseName2"));
	    }
	    
	    
	

}
