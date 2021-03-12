package com.reservation.reservationapplication.controller;

import com.reservation.reservationapplication.model.Facility;
import com.reservation.reservationapplication.service.FacilityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facility")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping("/create")
    public Facility create(@RequestBody Facility facility) {
        return facilityService.create(facility);
    }


}
