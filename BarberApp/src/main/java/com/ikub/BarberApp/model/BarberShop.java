package com.ikub.BarberApp.model;

import java.util.Date;
import java.util.List;

public class BarberShop {
    private String name;
    private List<Reservation> reservations;
    private Date startTime;
    private Date endTime;

    public BarberShop(String name, List<Reservation> reservations,Date startTime, Date endTime) {
        this.name = name;
        this.reservations = reservations;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
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
