package com.ikub.BarberApp.model;

import java.util.List
import java.util.Date;

public class Reservation {
    private User user;
    private List<TypeOfReservation> typeOfReservations;
    private Date startTime;
    private Date endTime;

    public Reservation(User user, List<TypeOfReservation> typeOfReservations, Date startTime, Date endTime) {
        this.user = user;
        this.typeOfReservations = typeOfReservations;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public List<TypeOfReservation> getTypeOfReservations() {
        return typeOfReservations;
    }

    public void setTypeOfReservations(List<TypeOfReservation> typeOfReservations) {
        this.typeOfReservations = typeOfReservations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
