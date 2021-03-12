package com.ikubinfo.reservation.resource;

import com.ikubinfo.reservation.request.ReservationCreateRequest;
import com.ikubinfo.reservation.request.ShopServiceCreateRequest;
import com.ikubinfo.reservation.request.UserCreateRequest;
import com.ikubinfo.reservation.model.Reservation;
import com.ikubinfo.reservation.model.ShopService;
import com.ikubinfo.reservation.model.User;
import com.ikubinfo.reservation.service.ReservationService;
import com.ikubinfo.reservation.service.ShopServiceService;
import com.ikubinfo.reservation.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SystemResource {
    private UserService userService;
    private ShopServiceService shopService;
    private ReservationService reservationService;

    public SystemResource(UserService userService,ShopServiceService service,ReservationService reservationService){
        this.userService = userService;
        this.shopService = service;
        this.reservationService = reservationService;
    }

    @PostMapping("/addUser")
    public User createUser(@RequestBody UserCreateRequest request){
        return userService.addUser(new User(request.getName(),
                                            request.getLastname(), request.getEmail()));
    }
    @PostMapping("/addService")
    public ShopService createService(@RequestBody ShopServiceCreateRequest request){
        return shopService.addShopService(new ShopService(request.getType(),
                                                request.getPrice(),request.getDescription()));
    }
    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody ReservationCreateRequest request){
       return reservationService.addReservation(new Reservation(request.getShopServiceType(),request.getUsername(),
               request.getStartDate(),request.getEndDate()));
    }


    @GetMapping("/getAllServices")
    public List<ShopService> getAllServices(){
        return shopService.getAllServices();
    }
    @GetMapping("/getAllUsers")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/getAllReservations")

    public List<Reservation> getAllReservations(){ return reservationService.getAll(); }

    @GetMapping
    @RequestMapping("/{type}")
    public List<Reservation> getReservations(@PathVariable String type){ return reservationService.getReservation(type); }
}
