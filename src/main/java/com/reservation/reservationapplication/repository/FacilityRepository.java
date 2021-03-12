package com.reservation.reservationapplication.repository;

import com.reservation.reservationapplication.model.Facility;

public interface FacilityRepository {

    Facility save(Facility service);
    Facility findByName(String name);

}
