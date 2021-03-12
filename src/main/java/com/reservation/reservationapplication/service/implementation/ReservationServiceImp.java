package com.reservation.reservationapplication.service.implementation;

import com.reservation.reservationapplication.exceptions.FacilityServiceManagementException;
import com.reservation.reservationapplication.exceptions.ReservationManagementException;
import com.reservation.reservationapplication.exceptions.UserManagementException;
import com.reservation.reservationapplication.model.Reservation;
import com.reservation.reservationapplication.repository.FacilityRepository;
import com.reservation.reservationapplication.repository.ReservationRepository;
import com.reservation.reservationapplication.repository.UserRepository;
import com.reservation.reservationapplication.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final FacilityRepository facilityRepository;

    public ReservationServiceImp(ReservationRepository reservationRepository, UserRepository userRepository, FacilityRepository facilityRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Reservation create(Reservation reservation) {

        if(Objects.isNull(userRepository.findByUsername(reservation.getUsername()))) {
            throw new UserManagementException("Username doesn't exist!");
        }

        if(Objects.isNull(facilityRepository.findByName(reservation.getFacility()))){
            throw new FacilityServiceManagementException("Facility doesn't exist!");
        }

        if(reservationRepository.exists(reservation) || !reservationRepository.availableReservation(reservation)) {
            throw new ReservationManagementException("Reservation not available!");
        } else {
            return reservationRepository.create(reservation);
        }

    }

    @Override
    public List<Reservation> getAllReservationsOfFacility(String name) {
        return reservationRepository.getAllReservationsOfFacility(name);
    }

}
