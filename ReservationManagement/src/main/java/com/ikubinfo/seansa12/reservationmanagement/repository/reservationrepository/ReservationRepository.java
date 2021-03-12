package com.ikubinfo.seansa12.reservationmanagement.repository.reservationrepository;

import java.util.List;

import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;

public interface ReservationRepository {
	
	Reservation save(Reservation reservation);
	
	Reservation update(Reservation reservation);
	
	boolean delete(String code);
	
	List <Reservation> getAll();
	
	Reservation findReservation(String code);
	
	List <Reservation> findReservations(String code);
	
	boolean existReservationWithCode(String code);
	
	 boolean existReservationForThisServiceInThisTime(Reservation reservation);
	
	
	
	
	
	

}
