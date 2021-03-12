package com.reservation.reservationapplication.service;

import com.reservation.reservationapplication.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);
    List<Reservation> getAllReservationsOfFacility(String name);

}
