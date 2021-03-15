package com.academy.monika.service.service.impl;

import com.academy.monika.service.customexception.CustomException;
import com.academy.monika.service.model.Reservation;
import com.academy.monika.service.repository.impl.ReservationRepository;
import com.academy.monika.service.repository.impl.ServiceRepository;
import com.academy.monika.service.repository.impl.UserRepository;
import com.academy.monika.service.service.CustomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements CustomService<Reservation> {
    ReservationRepository reservationRepository;
    UserRepository userRepository;
    ServiceRepository serviceRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, ServiceRepository serviceRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Reservation get(String uuid) {
        if (!reservationRepository.reservationExists(uuid)) {
            throw new CustomException("Reservation not found!");
        }
        return reservationRepository.get(uuid);
    }

    @Override
    public List<Reservation> getList() {
        return reservationRepository.getList();
    }

    @Override
    public Reservation add(Reservation obj) {
        checkNotNullValues(obj);
        if (reservationRepository.reservationExists(obj.getId())) {
            throw new CustomException("This reservation already exists!");
        }
        if (!serviceRepository.serviceExists(obj.getServiceId())) {
            throw new CustomException("Service not found!");
        }
        if (!userRepository.userExists(obj.getUserUuid())) {
            throw new CustomException("The user not found!");
        }
        if (obj.getStartTime().isAfter(obj.getEndTime())) {
            throw new CustomException("Start time should be before end time");
        }
        return reservationRepository.create(obj);
    }

    private void checkNotNullValues(Reservation reservation) {
        if (reservation.getId() == null
                || reservation.getServiceId() == null
                || reservation.getUserUuid() == null
                || reservation.getStartTime() == null
                || reservation.getEndTime() == null) {
            throw new CustomException("You have to complete all field!");
        }
    }

    @Override
    public Reservation update(String uuid, Reservation updatedObj) {
        updatedObj.setUserUuid(uuid);
        checkNotNullValues(updatedObj);
        if (!reservationRepository.reservationExists(updatedObj.getId())) {
            throw new CustomException("Reservation not found!");
        }
        if (!serviceRepository.serviceExists(updatedObj.getServiceId())) {
            throw new CustomException("Service not found!");
        }
        if (!userRepository.userExists(updatedObj.getUserUuid())) {
            throw new CustomException("The user not found!");
        }
        return reservationRepository.update(uuid, updatedObj);
    }

    @Override
    public Reservation delete(String uuid) {
        if (!reservationRepository.reservationExists(uuid)) {
            throw new CustomException("Reservation not found!");
        }
        return reservationRepository.delete(uuid);
    }

    public List<Reservation> getReservationPerService(String servicePathId) {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservationRepository.getList()) {
            if (servicePathId.equals(reservation.getServiceId())) {
                reservationList.add(reservation);
            }
        }
        return reservationList;
    }
}
