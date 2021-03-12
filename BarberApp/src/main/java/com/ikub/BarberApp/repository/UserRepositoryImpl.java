package com.ikub.BarberApp.repository;

import com.ikub.BarberApp.model.Reservation;
import com.ikub.BarberApp.model.TypeOfReservation;
import com.ikub.BarberApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    public List<User> users;
    UserRepository userRepository;

    public UserRepositoryImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        users= new ArrayList<>();
    }
    public User save(User user){
        users.add(user);
        return user;
    }

    public Reservation addServices(Reservation reservation, TypeOfReservation type){
        reservation.getTypeOfReservations().add(type);
        return reservation;
    }

    @Override
    public boolean existingUserWithEmail(String email) {
        for (User u: users){
            if (u.getEmail().equals(email)){
                return true;
            }
            break;
        }
        return false;
    }
}
