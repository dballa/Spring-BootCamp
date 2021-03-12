package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
@Component
public class ReservationRepositoryImpl implements ReservationRepository {
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	@Override
	public Reservation add(Reservation reservation) {
		reservations.add(reservation);
		return reservation;
	}

}
