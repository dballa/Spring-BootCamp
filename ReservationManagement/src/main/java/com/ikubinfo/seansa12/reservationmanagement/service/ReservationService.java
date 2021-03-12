package com.ikubinfo.seansa12.reservationmanagement.service;

import java.util.List;

import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;
import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.model.user.User;

public interface ReservationService {
	
	User addUser(User user);
	
	Services addService(Services service);
	
	Reservation addReservation(Reservation reservation);
	
	List<Reservation> allServiceReservations(String service);
	
//	Metoda shtese
	
	User returnUser(String username);
	
	Services returnService(String code);
	
//	Metoda shtese per user-in
	
	User updateUser(User user);

	boolean deleteUser(String username);

	List<User> getAllUsers();
	
//	Metoda shtese per servisin
	
	Services updateService(Services service);

	boolean deleteService(String code);

	List<Services> getAllServices();
	
//	Metoda shtese per rezervimin
	
	Reservation updateReservation(Reservation reservation);

	boolean deleteReservation(String code);
	
	Reservation findReservation(String code);

	List<Reservation> getAllReservations();

}
