package com.ikubinfo.seanca11.usermanagement.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.seanca11.reservationsmanagement.ReservationsManagmentExcpetion;
import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;
import com.ikubinfo.seanca11.usermanagement.repository.ReservationRepository;
import com.ikubinfo.seanca11.usermanagement.service.ReservationService;



@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationRepository userRepository;

	public ReservationServiceImpl(ReservationRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Users addUser(Users user) {

		if (userRepository.existUserWithUsername(user.getUsername())) {
			throw new ReservationsManagmentExcpetion("An user with this username exists");

		} else {
			return userRepository.save(user);
		}

	}


	@Override
	public Services addService(Services service) {
		if (userRepository.existServiceWithName(service.getServiceName())) {
			throw new ReservationsManagmentExcpetion("A service with this name exists");

		} else {
			return userRepository.save(service);
		}

	}

	@Override
	public Reservations management(Users username, Services service, LocalDateTime startDate, LocalDateTime endDate) {
		if (userRepository.existReservationWithService(service.getServiceName()) &&
				userRepository.existReservationWithDate(startDate)){
			throw new ReservationsManagmentExcpetion("A reservation with this service in this time exists");
		
		} else {
			return userRepository.save(username, service, startDate, endDate);
			
		}
		
	}

	@Override
	public Services getAll(List<Reservations> reservations) {

		return userRepository.getAll(reservations);
	}

	@Override
	public Reservations management(Reservations reservations) {
		
		return reservations;
	}

	

}
