package com.ikubinfo.seansa12.reservationmanagement.repository.reservationrepository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;
import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.repository.reservationrepository.ReservationRepository;

@Component
public class ReservataionRepositoryImpl implements ReservationRepository {

	private List<Reservation> reservations = new ArrayList<>();
	
	@Override
	public Reservation save(Reservation reservation) {
		
		if(reservations.add(reservation)) {
			return reservation;
		}else {
			return null;
		}
		
	}

	@Override
	public Reservation update(Reservation reservation) {
		
		for (Reservation existingReservation : reservations){
			if (existingReservation.getCode().equals(reservation.getCode())) {
				reservations.set(reservations.indexOf(existingReservation), reservation);
				return reservation;
			}
		}
		return null;
	}

	@Override
	public boolean delete(String code) {
		
		for (Reservation reservation : reservations) {
			if (reservation.getCode().equals(code)) {
				return reservations.remove(reservation);
			}
		}
		return false;
	}

	@Override
	public List<Reservation> getAll() {
		
		return reservations;
	}

	@Override
	public List<Reservation> findReservations(String code) {
		
		List <Reservation> serviceReservations = new ArrayList<>();
		
		for (Reservation reservation : reservations) {
			if (((Services) reservation.getService()).getCode().equals(code)) {
				serviceReservations.add(reservation);
			}
		}
		return serviceReservations;
	}

	@Override
	public boolean existReservationWithCode(String code) {
		
		for (Reservation reservation : reservations) {
			if (reservation.getCode().equals(code)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean existReservationForThisServiceInThisTime(Reservation reservation) {
		
		for (Reservation existingReservation : reservations) {
			if (existingReservation.getService().equals(reservation.getService()) 
					&& (reservation.getStartTime().isAfter(existingReservation.getStartTime())
							&& reservation.getStartTime().isBefore(existingReservation.getEndTime()))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Reservation findReservation(String code) {
		
		for (Reservation reservation : reservations) {
			if (reservation.getCode().equals(code)) {
				return reservation;
			}
		}
		return null;
	}

}
