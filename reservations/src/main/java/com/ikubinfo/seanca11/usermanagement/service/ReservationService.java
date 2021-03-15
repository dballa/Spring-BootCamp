package com.ikubinfo.seanca11.usermanagement.service;


import java.time.LocalDateTime;
import java.util.List;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;



public interface ReservationService {

	Users addUser(Users user);

	Services addService(Services service);

	Reservations management(Users username, Services service, LocalDateTime startDate, LocalDateTime endDate);


    Services getAll(List<Reservations> reservations);

	Reservations management(Reservations reservations);


	

	




}
