package com.ikubinfo.seanca11.usermanagement.web;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.seanca11.usermanagement.model.Reservations;
import com.ikubinfo.seanca11.usermanagement.model.Services;
import com.ikubinfo.seanca11.usermanagement.model.Users;
import com.ikubinfo.seanca11.usermanagement.service.ReservationService;
import com.ikubinfo.seanca11.usermanagement.web.request.UserCreateRequest;
import com.ikubinfo.seanca11.usermanagement.web.request.ReservationsRequest;
import com.ikubinfo.seanca11.usermanagement.web.request.ServiceCreateRequest;

@RestController
@RequestMapping("/reservations")
public class ReservationsResource {

	private ReservationService reservationService;

	public ReservationsResource(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@PostMapping
	@RequestMapping("/users")
	public Users createUser(@RequestBody UserCreateRequest request) {

		return reservationService
				.addUser(new Users(request.getFirstName(), request.getLastName(), request.getUsername(), request.getEmail()));

	}
	@PostMapping
	@RequestMapping("/services")
	public Services createService(@RequestBody ServiceCreateRequest request) {

		return reservationService
				.addService(new Services(request.getDescription(),  request.getServiceName(), request.getPrice()));

	}
	@PostMapping
	@RequestMapping("/reservations")
	public Reservations makeReservation(@RequestBody ReservationsRequest request) {

		return reservationService
				.management(new Reservations(request.getUsername(), request.getService(), request.getStartDate(), request.getEndDate()));

	}



	@GetMapping
	@RequestMapping("/all")
	public Services getAll(List<Reservations> reservations) {
		return reservationService.getAll(reservations);
	}


}
