package com.ikubinfo.seanca11.usermanagement.repository.impl;


import java.time.LocalDateTime;

import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;
import com.ikubinfo.seanca11.usermanagement.repository.ReservationRepository;

@Component
public class ReservationsRepositoryImpl implements ReservationRepository {
	
	
	public List<Reservations> reservations=new ArrayList<>();
	public List<Users> users=new ArrayList<>();
	public List<Services> services=new ArrayList<>();

	@Override
	public Users save(Users user) {
		
		if(users.add(user)) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public Services save(Services service) {
		
		if(services.add(service)) {
			return service;
		}else {
			return null;
		}
	}

	@Override
	public Reservations save(Users username, Services service, LocalDateTime startDate, LocalDateTime endDate) {
		
		Reservations reservation =new Reservations(username, service, endDate, endDate);
		if(reservations.add(reservation)) {
			return reservation;
		}else {
			return null;
		}

	}

	@Override
	public Services getAll(List<Reservations> reservations) {
		
		Services service =new Services(reservations);
		if(services.add(service)) {
			return service;
		}else {
			return null;
		}
	}

	@Override
	public boolean existUserWithUsername(String username) {
		for (Users user: users) {
			if(user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existServiceWithName(String serviceName) {
		for (Services service: services) {
			if(service.getServiceName().equals(serviceName)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean existReservationWithService(String serviceName) {
		for (Reservations service: reservations) {
			if(service.getService().equals(serviceName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existReservationWithDate(LocalDateTime localTime) {
		for (Reservations startDate: reservations) {
			if(startDate.getStartDate().equals(localTime) ||
					startDate.getStartDate().isBefore(localTime) && startDate.getEndDate().isAfter(localTime)||
					startDate.getStartDate().isAfter(localTime) && startDate.getEndDate().isAfter(localTime)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Reservations save(Reservations reservation) {
		if(reservations.add(reservation)) {
			return reservation;
		}else {
			return null;
		}
	}


	
	
	

}
