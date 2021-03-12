package com.ikubinfo.seansa12.reservationmanagement.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;
import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.model.user.User;
import com.ikubinfo.seansa12.reservationmanagement.service.ReservationService;
import com.ikubinfo.seansa12.reservationmanagement.web.request.ReservationRequest;
import com.ikubinfo.seansa12.reservationmanagement.web.request.ServiceRequest;
import com.ikubinfo.seansa12.reservationmanagement.web.request.UserRequest;

@RestController
@RequestMapping("/")
public class ReservationManagementResource {
	
	private ReservationService reservationService;

	public ReservationManagementResource(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@PostMapping
	@RequestMapping("/user")
	public User createUser(@RequestBody UserRequest request) {

		return reservationService
				.addUser(new User(request.getFirstName(), request.getLastName(), request.getAge(), request.getEmail()));

	}
	@PutMapping
	@RequestMapping("/user/update")
	public User updateUser(@RequestBody UserRequest request) {

		return reservationService.updateUser(
				new User(request.getFirstName(), request.getLastName(), request.getAge(), request.getEmail()));

	}

	@DeleteMapping
	@RequestMapping("user/delete/{username}")
	public void deleteUser(@PathVariable String username) {

		reservationService.deleteUser(username);
	}

	@GetMapping
	@RequestMapping("/user/all")
	public List<User> getAllUser() {
		return reservationService.getAllUsers();
	}
	
	@GetMapping
	@RequestMapping("user/find/{username}")
	public User getUserByUsername(@PathVariable String username) {

		return reservationService.returnUser(username);
	}
	
	@PostMapping
	@RequestMapping("/service")
	public Services createService(@RequestBody ServiceRequest request) {

		return reservationService
				.addService(new Services(request.getName(), request.getDescription()));

	}
	@PutMapping
	@RequestMapping("/service/update")
	public Services updateService(@RequestBody ServiceRequest request) {

		return reservationService.updateService(new Services(request.getName(), request.getDescription()));

	}

	@DeleteMapping
	@RequestMapping("service/delete/{code}")
	public void deleteService(@PathVariable String code) {

		reservationService.deleteService(code);
	}

	@GetMapping
	@RequestMapping("/service/all")
	public List<Services> getAllService() {
		return reservationService.getAllServices();
	}
	
	@GetMapping
	@RequestMapping("service/find/{service}")
	public Services getServiceByCode(@PathVariable String service) {

		return reservationService.returnService(service);
	}
	
	@PostMapping
	@RequestMapping("/user/reservation")
	public Reservation createReservation(@RequestBody ReservationRequest request) {

		return reservationService
				.addReservation(new Reservation(reservationService.returnUser(request.getUsername()), reservationService.returnService(request.getServiceCode()),request.getStartTime(),request.getEndTime()));

	}
	@PutMapping
	@RequestMapping("/user/reservation/update")
	public Reservation updateReservation(@RequestBody ReservationRequest request) {

		return reservationService.
				updateReservation(new Reservation(reservationService.returnUser(request.getUsername()), reservationService.returnService(request.getServiceCode()),request.getStartTime(),request.getEndTime()));

	}

	@DeleteMapping
	@RequestMapping("/reservation/delete/{code}")
	public void deleteReservation(@PathVariable String code) {

		reservationService.deleteReservation(code);
	}

	@GetMapping
	@RequestMapping("/reservation/all")
	public List<Reservation> getAllReservation() {
		return reservationService.getAllReservations();
	}
	
	@GetMapping
	@RequestMapping("reservation/find/{service}")
	public Reservation getReservationByCode(@PathVariable String code) {

		return reservationService.findReservation(code);
	}
	@GetMapping
	@RequestMapping("/service/{code}")
	public List<Reservation> allServiceReservations(@PathVariable String code) {
		return reservationService.allServiceReservations(code);
	}
}
