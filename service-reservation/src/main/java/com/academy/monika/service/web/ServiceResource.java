package com.academy.monika.service.web;

import com.academy.monika.service.model.OfferedService;
import com.academy.monika.service.model.Reservation;
import com.academy.monika.service.service.impl.OfferedServiceImpl;
import com.academy.monika.service.service.impl.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceResource {

    private OfferedServiceImpl offeredService;
    private ReservationServiceImpl reservationService;

    public ServiceResource(OfferedServiceImpl offeredService, ReservationServiceImpl reservationService) {
        super();
        this.offeredService = offeredService;
        this.reservationService=reservationService;
    }

    @GetMapping
    public List<OfferedService> getAllServices() {
        return offeredService.getList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OfferedService getService(@PathVariable String id) {
        return offeredService.get(id);
    }

    @PostMapping
    public OfferedService createService(@RequestBody OfferedService service) {
        return offeredService.add(service);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public OfferedService updateService(@PathVariable String id, @RequestBody OfferedService service) {
        return offeredService.update(id, service);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public OfferedService deleteService(@PathVariable String id) {
        return offeredService.delete(id);
    }

    @RequestMapping("/{id}/reservation")
    public List<Reservation> reservationResource(@PathVariable String id){
        return reservationService.getReservationPerService(id);
    }
}
