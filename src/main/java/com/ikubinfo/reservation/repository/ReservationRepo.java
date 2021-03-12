package com.ikubinfo.reservation.repository;

import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;

import java.util.List;

public interface ReservationRepo {
    Reservation addReservation(Reservation reservation);
    boolean exists(Reservation reservation);
    List<Reservation> getReservation(String type);
    List<Reservation> getAll();
    boolean existsUser(List<User> userList,Reservation reservation);
    boolean existsService(List<ShopService> shopServiceList,Reservation reservation);
}
