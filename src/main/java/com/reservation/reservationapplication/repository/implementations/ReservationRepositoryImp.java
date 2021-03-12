package com.reservation.reservationapplication.repository.implementations;

import com.reservation.reservationapplication.model.Reservation;
import com.reservation.reservationapplication.repository.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepositoryImp implements ReservationRepository {
    
    public List<Reservation> reservations;
    
    public ReservationRepositoryImp() {
        reservations = new ArrayList<>();
    }
    
    @Override
    public Reservation create(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Boolean exists(Reservation reservation) {
        for(Reservation res : reservations) {
            if(res.equals(reservation)) return true;
        }
        return false;
    }

    @Override
    public Boolean availableReservation(Reservation reservation) {
        for(Reservation res : reservations) {
           if(isNotAvailable(reservation, res)) {
               return false;
           }
        }
        return true;
    }

    @Override
    public List<Reservation> getAllReservationsOfFacility(String name) {

        List<Reservation> reservations = new ArrayList<>();

        for(Reservation reservation : this.reservations) {
            if(reservation.getFacility().equals(name)) reservations.add(reservation);
        }
        return reservations;
    }

    private boolean isNotAvailable(Reservation reservation, Reservation res) {
        return sameFacility(reservation, res) && (isBetweenReservation(reservation, res) || interleavesWithReservation(reservation, res));
    }

    private boolean interleavesWithReservation(Reservation reservation, Reservation res) {
        return reservation.getStart().compareTo(res.getStart()) < 0 && reservation.getEnd().compareTo(res.getStart()) > 0;
    }

    private boolean isBetweenReservation(Reservation reservation, Reservation res) {
        return reservation.getStart().compareTo(res.getStart()) > 0 && reservation.getStart().compareTo(res.getEnd()) < 0;
    }

    private boolean sameFacility(Reservation reservation, Reservation res) {
        return reservation.getFacility().equals(res.getFacility());
    }
}
