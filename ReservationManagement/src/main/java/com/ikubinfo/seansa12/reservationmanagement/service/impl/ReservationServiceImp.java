package com.ikubinfo.seansa12.reservationmanagement.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ikubinfo.seansa12.reservationmanagement.exception.ReservationManagementException;
import com.ikubinfo.seansa12.reservationmanagement.model.reservation.Reservation;
import com.ikubinfo.seansa12.reservationmanagement.model.service.Services;
import com.ikubinfo.seansa12.reservationmanagement.model.user.User;
import com.ikubinfo.seansa12.reservationmanagement.repository.reservationrepository.ReservationRepository;
import com.ikubinfo.seansa12.reservationmanagement.repository.servicerepository.ServiceRepository;
import com.ikubinfo.seansa12.reservationmanagement.repository.userrepository.UserRepository;
import com.ikubinfo.seansa12.reservationmanagement.service.ReservationService;

@Service
public class ReservationServiceImp implements ReservationService{

	private UserRepository userRepository;
	private ServiceRepository serviceRepository;
	private ReservationRepository reservationRepository;
	
	public ReservationServiceImp(UserRepository userRepository, ServiceRepository serviceRepository,
			ReservationRepository reservationRepository) {
		super();
		this.userRepository = userRepository;
		this.serviceRepository = serviceRepository;
		this.reservationRepository = reservationRepository;
	}

	@Override
	public User addUser(User user) {
		
		if (userRepository.existUserWithUsername(user.getUsername())) {
			throw new ReservationManagementException("An user with this username exists");

		} else {
			return userRepository.save(user);
		}
	}

	@Override
	public Services addService(Services service) {
		
		if (serviceRepository.existServiceWithCode(service.getCode())) {
			throw new ReservationManagementException("An service with this code exists");

		} else {
			return serviceRepository.save(service);
		}
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		
		if (reservationRepository.existReservationForThisServiceInThisTime(reservation)||reservationRepository.existReservationWithCode(reservation.getCode())) {
			throw new ReservationManagementException("An service with this code and in this time exists");

		} else {
			return reservationRepository.save(reservation);
		}
	}

	@Override
	public List<Reservation> allServiceReservations(String code) {
		
		if (!serviceRepository.existServiceWithCode(code)) {
			throw new ReservationManagementException("An service with this code doesn't exists");

		} else {
			return reservationRepository.findReservations(code);
		}
		
	}
//	Metoda shtese
	@Override
	public User returnUser(String username) {
		
		User existingUser = userRepository.findUser(username);
		if(existingUser==null){
			throw new ReservationManagementException("This username doesn't exists");
		}
		else {
			return existingUser;
		}
		
	}

	@Override
	public Services returnService(String code) {
		
		Services existingService = serviceRepository.findService(code);
		if(existingService==null){
			throw new ReservationManagementException("This service doesn't exists");
		}
		else {
			return existingService;
		}
	}
	
//	Metoda shtese per user-in
	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findUser(user.getUsername());

		if (Objects.isNull(existingUser)) {
			throw new ReservationManagementException("User doesn't exists");
		}

		existingUser.setAge(user.getAge());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());

		return userRepository.update(existingUser);

	}

	@Override
	public boolean deleteUser(String username) {
		if (!userRepository.existUserWithUsername(username)) {
			throw new ReservationManagementException("An user with this doesn't exists");

		} else {
			return userRepository.delete(username);
		}

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAll();
	}
	
//	Metoda shtese per servisin
	@Override
	public Services updateService(Services service) {
		Services existingService = serviceRepository.findService(service.getCode());

		if (Objects.isNull(existingService)) {
			throw new ReservationManagementException("Service doesn't exists");
		}

		existingService.setName(service.getName());
		existingService.setDescription(service.getDescription());

		return serviceRepository.update(existingService);

	}

	@Override
	public boolean deleteService(String code) {
		if (!serviceRepository.existServiceWithCode(code)) {
			throw new ReservationManagementException("An service with this doesn't exists");

		} else {
			return serviceRepository.delete(code);
		}

	}

	@Override
	public List<Services> getAllServices() {
		return serviceRepository.getAll();
	}
	
//	Metoda shtese per reservimet
	@Override
	public Reservation updateReservation(Reservation reservation) {
		Reservation existingReservation = reservationRepository.findReservation(reservation.getCode());

		if (Objects.isNull(existingReservation)) {
			throw new ReservationManagementException("Reservation doesn't exists");
		}

		existingReservation.setUser(reservation.getUser());
		existingReservation.setService(reservation.getService());
		existingReservation.setStartTime(reservation.getStartTime());
		existingReservation.setEndTime(reservation.getEndTime());

		return reservationRepository.update(existingReservation);

	}

	@Override
	public boolean deleteReservation(String code) {
		if (!reservationRepository.existReservationWithCode(code)) {
			throw new ReservationManagementException("A reservation with this doesn't exists");

		} else {
			return reservationRepository.delete(code);
		}

	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.getAll();
	}

	@Override
	public Reservation findReservation(String code) {
		
		Reservation existingReservation = reservationRepository.findReservation(code);
		if(existingReservation==null){
			throw new ReservationManagementException("This reservation doesn't exists");
		}
		else {
			return existingReservation;
		}
	}
}
