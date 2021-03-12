package com.ikub.BarberApp.service;

import com.ikub.BarberApp.model.BarberShop;
import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.TypeOfReservation;
import com.ikub.BarberApp.model.User;

public interface UserService {
    public User addUser(User user);

    public Reservation addReservation(Reservation reservation);
}
