package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.web.request.CreateReservationRequest;

public interface ReservationService {
	
	Reservation add(CreateReservationRequest reservationRequest);
}
