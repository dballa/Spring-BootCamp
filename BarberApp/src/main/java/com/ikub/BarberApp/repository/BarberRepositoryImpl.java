package com.ikub.BarberApp.repository;

import com.ikub.BarberApp.UserExeption;
import com.ikub.BarberApp.model.BarberShop;
import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class BarberRepositoryImpl implements BarberRepository{

    public List<Reservation> reservations=new ArrayList<>();
    BarberRepository barberRepository;

    public BarberRepositoryImpl(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation findReservation(Reservation reservation) {
        for (Reservation r: reservations){
            if (!r.getUser().equals(reservation.getUser())){
                throw new UserExeption("An user don't exists");
            }else
                break;
        }
        return reservation;
    }

    @Override
    public Boolean deleteReservation(Reservation reservation) {
        if (barberRepository.existingReservationWithUser(reservation.getUser())) {
            return reservations.remove(reservation);
        }
        return false;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public boolean existingReservationWithUser(User user) {
        for (Reservation r: reservations){
            if (!r.getUser().equals(user)){
                return false;
            }else{
                break;
            }
        }
        return true;
    }
}
