package com.reservation.reservationapplication.repository;

import com.reservation.reservationapplication.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    Reservation create(Reservation reservation);
    Boolean exists(Reservation reservation);
    Boolean availableReservation(Reservation reservation);
    List<Reservation> getAllReservationsOfFacility(String name);

}
