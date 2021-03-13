package com.ikubinfo.reservation.service.impl;

import com.ikubinfo.reservation.exceptions.ReservationException;
import com.ikubinfo.reservation.exceptions.ShopServiceManagementException;
import com.ikubinfo.reservation.exceptions.UserManagementException;
import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import com.ikubinfo.reservation.repository.ShopServiceRepo;
import com.ikubinfo.reservation.repository.UserRepo;
import com.ikubinfo.reservation.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepo reservationRepo ;
    private UserRepo userRepo;
    private ShopServiceRepo shopServiceRepo;

    public ReservationServiceImpl(ReservationRepo reservationRepo, UserRepo userRepo, ShopServiceRepo shopServiceRepo) {
        this.reservationRepo = reservationRepo;
        this.userRepo = userRepo;
        this.shopServiceRepo = shopServiceRepo;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        if (reservationRepo.exists(reservation))
            throw new ReservationException("A reservation already exists at that time");
        if (!existsUser(userRepo.getAll(),reservation))
            throw new UserManagementException(" User does not exist ");
        if (!existsService(shopServiceRepo.getAllServices(),reservation))
            throw new ShopServiceManagementException("Service does not exist");
        return reservationRepo.addReservation(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.getAll();
    }

    @Override
    public List<Reservation> getReservation(String serviceType) {
        return reservationRepo.getReservation(serviceType);
    }

    @Override
    public boolean existsReservation(Reservation reservation) {
        return reservationRepo.exists(reservation);
    }

    @Override
    public boolean existsUser(List<User> userList, Reservation reservation) {
        return reservationRepo.existsUser(userList,reservation);
    }

    @Override
    public boolean existsService(List<ShopService> shopServiceList,Reservation reservation) {
        return reservationRepo.existsService(shopServiceList,reservation);
    }

}
