package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.FacilityServiceManagementException;
import com.reservation.reservationapplication.model.Facility;
import com.reservation.reservationapplication.repository.FacilityRepository;
import com.reservation.reservationapplication.service.FacilityService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FacilityServiceImp implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceImp(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility create(Facility service) {
        if(!Objects.isNull(facilityRepository.findByName(service.getName()))) {
            throw new FacilityServiceManagementException("Facility already exists!");
        }else {
            return facilityRepository.save(service);
        }
    }
}
