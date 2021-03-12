package com.ikubinfo.reservation.service;

import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    List<Reservation> getAll();
    List<Reservation> getReservation(String serviceType);
    boolean existsReservation(Reservation reservation);
    boolean existsUser(List<User> userList, Reservation reservation);
    boolean existsService(List<ShopService> shopServiceList,Reservation reservation);
}
