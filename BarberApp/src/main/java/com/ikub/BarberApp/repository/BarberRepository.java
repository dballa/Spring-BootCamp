package com.ikub.BarberApp.repository;

import com.ikub.BarberApp.model.BarberShop;
import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.User;

public interface BarberRepository {
        public Reservation addReservation(Reservation reservation);

        public Reservation findReservation(Reservation reservation);

        public Boolean deleteReservation(Reservation reservation);

        public Reservation updateReservation(Reservation reservation);

        public boolean existingReservationWithUser(User user);


}
