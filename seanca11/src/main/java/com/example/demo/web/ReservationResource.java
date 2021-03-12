package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.web.request.CreateReservationRequest;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {
	private ReservationService reservationService;

	public ReservationResource(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	
	@PostMapping
	public Reservation addReservation(@RequestBody CreateReservationRequest reservationRequest) {
		System.out.println(reservationRequest);
		return reservationService.add(reservationRequest);
	}

}
