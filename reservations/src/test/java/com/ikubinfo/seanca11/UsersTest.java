package com.ikubinfo.seanca11;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ikubinfo.seanca11.usermanagement.model.Users;
import com.ikubinfo.seanca11.usermanagement.repository.ReservationRepository;
import com.ikubinfo.seanca11.usermanagement.repository.impl.ReservationsRepositoryImpl;
import com.ikubinfo.seanca11.usermanagement.service.ReservationService;
import com.ikubinfo.seanca11.usermanagement.service.impl.ReservationServiceImpl;

public class UsersTest {
	
	    static ReservationRepository usersRepo ;
	    static ReservationService usersService ;
	    static Users user1 ;
	    static Users user2 ;
	    
	  @BeforeAll
	    static void init(){
	        usersRepo = mock(ReservationsRepositoryImpl.class);
	        usersService = mock(ReservationServiceImpl.class);
	         user1 = new Users("mersih","Mersi", "Huqi","mersi@123");
	         user2 = new Users("username","FirstName", "LastName","email");
	    }
	  
	  @Test
	    void addUsersTestService(){
	        when(usersService.addUser(user1)).thenReturn(user1);
	        assertNotNull(usersService.addUser(user1));
	        
	        when(usersService.addUser(user2)).thenReturn(user2);
	        assertNotNull(usersService.addUser(user2));
	    }
	    @Test
	    void saveUsersTestRepo(){
	        when(usersRepo.save(user1)).thenReturn(user1);
	        assertNotNull(usersRepo.save(user1));
	        
	        when(usersRepo.save(user2)).thenReturn(user2);
	        assertNotNull(usersRepo.save(user2));
	    }
	    @Test
	    void existUserWithUsernameRepo(){
	        when(usersRepo.existUserWithUsername("mersih")).thenReturn(true);
	        assertTrue(usersRepo.existUserWithUsername("mersih"));
	        assertFalse(usersRepo.existUserWithUsername("falseUsername"));
	        
	        when(usersRepo.existUserWithUsername("username")).thenReturn(true);
	        assertTrue(usersRepo.existUserWithUsername("username"));
	        assertFalse(usersRepo.existUserWithUsername("false"));
	    }
	   

	

}
