package com.academy.monika.service.repository.impl;

import com.academy.monika.service.model.Reservation;
import com.academy.monika.service.repository.CustomRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationRepository implements CustomRepository<Reservation> {
    private List<Reservation> reservationList = new ArrayList<>();

    @Override
    public Reservation get(String uuid) {
        for (Reservation reservation : reservationList) {
            if (uuid.equals(reservation.getId())) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public List<Reservation> getList() {
        return reservationList;
    }

    @Override
    public Reservation create(Reservation obj) {
        reservationList.add(obj);
        return obj;
    }

    @Override
    public Reservation update(String uuid, Reservation updatedObj) {

        for (Reservation reservation : reservationList) {
            if (uuid.equals(reservation.getId())) {
                reservation.setEndTime(updatedObj.getEndTime());
                reservation.setStartTime(updatedObj.getStartTime());
                reservation.setServiceId(updatedObj.getServiceId());
                reservation.setUserUuid(updatedObj.getUserUuid());
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation delete(String uuid) {
        for (Reservation reservation : reservationList) {
            if (uuid.equals(reservation.getId())) {
                reservationList.remove(reservation);
            }
        }
        return null;
    }
    public Boolean reservationExists(String uuid) {
        for (Reservation reservation : reservationList) {
            if (uuid.equals(reservation.getId())) {
                return true;
            }
        }
        return false;
    }
}
