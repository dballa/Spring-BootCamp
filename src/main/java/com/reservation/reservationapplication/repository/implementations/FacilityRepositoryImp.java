package com.reservation.reservationapplication.repository.implementations;

import com.reservation.reservationapplication.model.Facility;
import com.reservation.reservationapplication.repository.FacilityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacilityRepositoryImp implements FacilityRepository {

    private final List<Facility> services;

    public FacilityRepositoryImp() {
        services = new ArrayList<>();
    }

    @Override
    public Facility save(Facility service) {
        services.add(service);
        return service;
    }

    @Override
    public Facility findByName(String name) {
        for(Facility service : services) {
            if(service.getName().equals(name)) return service;
        }
        return null;
    }

}
