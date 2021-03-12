package com.ikubinfo.seansa12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;
import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.model.user.User;
import com.ikubinfo.seansa12.reservationmanagement.repository.reservationrepository.ReservationRepository;
import com.ikubinfo.seansa12.reservationmanagement.repository.servicerepository.ServiceRepository;
import com.ikubinfo.seansa12.reservationmanagement.repository.userrepository.UserRepository;
import com.ikubinfo.seansa12.reservationmanagement.service.impl.ReservationServiceImp;

public class ReservationManagementUseCases {
	
	private ReservationServiceImp reservationService;
	
	private ReservationRepository reservationRepository;
	private UserRepository userRepository;
	private ServiceRepository serviceRepository;
	
	@BeforeEach
	public void initializeBeforeAllTestMethods() {
		
		reservationRepository = Mockito.mock(ReservationRepository.class);
		userRepository = Mockito.mock(UserRepository.class);
		serviceRepository = Mockito.mock(ServiceRepository.class);
		
		reservationService = new ReservationServiceImp(userRepository,serviceRepository,reservationRepository);
	}
	
	@Test
	public void successfullAddOfUser() {
		
		String firstName ="Danjela";
		String lastName="Tola";
		String age="21";
		String email="danjela.tola@gmail.com";
		
		User user= new User(firstName,lastName,age,email);

		when(userRepository.save(user)).thenReturn(user);

		User response = reservationService.addUser(user);
		assertNotNull(response);
		assertEquals(response, user);

	}
	@Test
	public void successfullAddOfService() {
		
		String name ="Dentist";
		String description="Dentists are responsible for anything regarding the health of the mouth, including the teeth, gums and dental tissues.";

		
		Services service= new Services(name,description);

		when(serviceRepository.save(service)).thenReturn(service);

		Services response = reservationService.addService(service);
		assertNotNull(response);
		assertEquals(response, service);

	}
	@Test
	public void successfullAddOfReservation() {
		
		String firstName ="Danjela";
		String lastName="Tola";
		String age="21";
		String email="danjela.tola@gmail.com";
		
		String name ="Dentist";
		String description="Dentists are responsible for anything regarding the health of the mouth, including the teeth, gums and dental tissues.";

		LocalDateTime startTime=LocalDateTime.of(2020,12,12,12,13);
		LocalDateTime endTime=LocalDateTime.of(2020,12,12,14,13);
		
		User user= new User(firstName,lastName,age,email);
		Services service= new Services(name,description);

		Reservation reservation = new Reservation(user,service,startTime,endTime);
		
		when(reservationRepository.save(reservation)).thenReturn(reservation);

		Reservation response = reservationService.addReservation(reservation);
		assertNotNull(response);
		assertEquals(response, reservation);

	}
	@Test
	public void successfullAllServiceReservations() {
		
		String firstNameFirstUser ="Danjela";
		String lastNameFirstUser="Tola";
		String ageFirstUser="21";
		String emailFirstUser="danjela.tola@gmail.com";
		
		String firstNameSecondUser ="Danjela";
		String lastNameSecondUser="Tola";
		String ageSecondUser="21";
		String emailSecondUser="danjela.tola@gmail.com";
		
		String name ="Dentist";
		String description="Dentists are responsible for anything regarding the health of the mouth, including the teeth, gums and dental tissues.";

		LocalDateTime startTime=LocalDateTime.of(2020,12,12,12,13);
		LocalDateTime endTime=LocalDateTime.of(2020,12,12,14,13);
		
		LocalDateTime startTime2=LocalDateTime.of(2020,12,12,15,13);
		LocalDateTime endTime2=LocalDateTime.of(2020,12,12,17,13);
		
		User firstUser= new User(firstNameFirstUser,lastNameFirstUser,ageFirstUser,emailFirstUser);
		User secondUser= new User(firstNameSecondUser,lastNameSecondUser,ageSecondUser,emailSecondUser);
		Services service= new Services(name,description);

		Reservation reservation1 = new Reservation(firstUser,service,startTime,endTime);
		Reservation reservation2 = new Reservation(secondUser,service,startTime2,endTime2);
		
		List<Reservation> reservations= new ArrayList<>();
		reservations.add(reservation1);
		reservations.add(reservation2);
		
		when(reservationRepository.findReservations(service.getCode())).thenReturn(reservations);
		
		List<Reservation> response = reservationService.allServiceReservations(service.getCode());
		assertNotNull(response);
		assertEquals(response, reservations);
	}

}
