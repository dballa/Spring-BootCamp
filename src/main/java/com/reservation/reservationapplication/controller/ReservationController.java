package com.reservation.reservationapplication.controller;

import com.reservation.reservationapplication.model.Reservation;
import com.reservation.reservationapplication.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping("/{facility}")
    public List<Reservation> allReservationsOfParticularFacility(@PathVariable String facility) {
        return reservationService.getAllReservationsOfFacility(facility);
    }


}
