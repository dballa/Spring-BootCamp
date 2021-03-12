package com.example.demo.service.impl;

import com.example.demo.model.Reservation;
import com.example.demo.model.Service;
import com.example.demo.model.User;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ReservationService;
import com.example.demo.web.request.CreateReservationRequest;


@org.springframework.stereotype.Service
public class ReservationServiceImpl implements ReservationService {

	ReservationRepository reservationRepository;
	ServiceRepository serviceRepository;
	UserRepository userRepository;
	
	public ReservationServiceImpl(ReservationRepository reservationRepository, ServiceRepository serviceRepository,
			UserRepository userRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.serviceRepository = serviceRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Reservation add(CreateReservationRequest reservationRequest) {
		// TODO Auto-generated method stub
		User user = userRepository.getUserByEmail(reservationRequest.getEmail());
		Service service = serviceRepository.getServiceByName(reservationRequest.getServiceName());
		
		Reservation reservation = new Reservation();
		
		reservation.setUser(user);
		reservation.setService(service);
		reservation.setStartDate(reservationRequest.getStartDate());
		reservation.setEndDate(reservationRequest.getEndDate());
		
		return reservationRepository.add(reservation);
	}


}
