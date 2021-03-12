package web;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.EmployeeService;
import model.Reservation;
import model.ShopService;
import model.User;
import service.BarberShopService;

@RestController
@RequestMapping
public class BarberShopResource {

	private BarberShopService barberShopService;

	public BarberShopResource(BarberShopService barberShopService) {
		super();
		this.barberShopService = barberShopService;
	}

	@PostMapping("/user")
	public User createUser(@RequestBody UserCreateRequest request) {

		return barberShopService.addUser(new User(request.getFirstName(), request.getLastName(), request.getEmail()));

	}
	
	    @PostMapping("/service")
	    public ShopService createService(@RequestBody ShopServiceCreateRequest request){
	        return barberShopService.addService(new ShopService(request.getName(),
	                                                request.getPrice(),request.getDescription()));
	    }
	    @PostMapping("/reservation")
	    public Reservation addReservation(@RequestBody ReservationCreateRequest request){
	       return barberShopService.manageReservationList(new User(request.getFirstName(), request.getLastName(), request.getEmail()), new Reservation());
	    }

	    @GetMapping
	    @RequestMapping("/{name}")
	    public List<Reservation> getReservations(@PathVariable String name){ return barberShopService.getAll(new EmployeeService()); }
	}

