package com.ikubinfo.reservation.repository.impl;

import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.repository.ReservationRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationRepoImpl implements ReservationRepo {
    private List<Reservation> reservationList = new ArrayList<>();


    public boolean isBetween(LocalDateTime moment, LocalDateTime begin, LocalDateTime end){
         return moment.isAfter(begin) && moment.isBefore(end);
    }
    public boolean areTheSame(LocalDateTime moment,LocalDateTime begin){
        return moment.equals(begin) ;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        reservationList.add(reservation);
        return reservation;
    }

    @Override
    public boolean exists(Reservation reservation) {
        //if (reservationList.isEmpty()) return false;
        for (Reservation res : reservationList) {
            if (isServiceTheSame(res.getShopServiceType(), reservation.getShopServiceType())) {
                if (dateOverlay(reservation.getStartDate(),reservation.getEndDate(),res.getStartDate(),res.getEndDate())
                            || startEndOverlay(reservation.getStartDate(),reservation.getEndDate(),res.getStartDate(),res.getEndDate())) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dateOverlay(LocalDateTime start,LocalDateTime end,LocalDateTime definedStart,LocalDateTime definedEnd){
        return isBetween(start, definedStart, definedEnd)
                || isBetween(end, definedStart, definedEnd);
    }
    private boolean startEndOverlay(LocalDateTime start,LocalDateTime end,LocalDateTime definedStart,LocalDateTime definedEnd){
        return areTheSame(start, definedStart) || areTheSame(end,definedEnd);
    }
    private boolean isServiceTheSame(String shopServiceType, String shopServiceType2) {
        return shopServiceType.compareTo(shopServiceType2) == 0;
    }

    @Override
    public List<Reservation> getReservation(String type) {
        List<Reservation> reservations = new ArrayList<>();
        for (Reservation res : reservationList) {
            if (isServiceTheSame(res.getShopServiceType(), type)) {
                reservations.add(res);
            }
        }
        return reservations;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationList;
    }

    @Override
    public boolean existsService(List<ShopService> shopServiceList, Reservation reservation) {
         boolean existsService = false;
        for (ShopService service : shopServiceList){
            if (service.getType().compareTo(reservation.getShopServiceType())==0){
                existsService = true;
                break;
            }
        }
        return existsService;
    }
    @Override
    public boolean existsUser(List<User> userList,Reservation reservation) {
        boolean existsUser = false;
        for (User user : userList){
            if (user.getUsername().compareTo(reservation.getUsername())==0){
                existsUser = true;
                break;
            }
        }
        return existsUser;
    }
}
