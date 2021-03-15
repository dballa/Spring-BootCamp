package com.academy.monika.service.web;

import com.academy.monika.service.model.Reservation;
import com.academy.monika.service.service.impl.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationResource {

    private ReservationServiceImpl reservationService;

    public ReservationResource(ReservationServiceImpl reservationService) {
        super();
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable String id) {
        return reservationService.get(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.add(reservation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Reservation deleteReservation(@PathVariable String id) {
        return reservationService.delete(id);
    }

}
