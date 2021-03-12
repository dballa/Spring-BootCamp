package com.ikub.BarberApp.service;

import com.ikub.BarberApp.UserExeption;
import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.TypeOfReservation;
import com.ikub.BarberApp.model.User;
import com.ikub.BarberApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
        UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        if(!userRepository.existingUserWithEmail(user.getEmail())){
            throw new UserExeption("An user dont exist ");
        }else

        return  userRepository.save(user);
    }

    @Override
    public Reservation addReservation(Reservation reservation){
    return   userRepository.addServices(reservation,reservation.getTypeOfReservations().get());
    }
}
