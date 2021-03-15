package com.ikubinfo.seanca11.usermanagement.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;



public interface ReservationRepository {

	Users save(Users user);
	Services save(Services service);
	Reservations save(Users username, Services service, LocalDateTime startDate, LocalDateTime endDate);
	Reservations save(Reservations reservation);

	Services getAll(List<Reservations> reservations);

	boolean existUserWithUsername(String username);
	boolean existServiceWithName(String serviceName);
	boolean existReservationWithService(String serviceName);
	boolean existReservationWithDate(LocalDateTime localTime);
}
