package com.ikub.BarberApp.repository;

import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.TypeOfReservation;
import com.ikub.BarberApp.model.User;

import java.util.List;


public interface UserRepository {
    public User save(User user);

    public Reservation addServices(Reservation reservation,TypeOfReservation type);

    public boolean existingUserWithEmail(String email);


}
