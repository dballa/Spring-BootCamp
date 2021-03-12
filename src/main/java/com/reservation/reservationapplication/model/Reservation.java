package com.reservation.reservationapplication.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {

    private String username;
    private LocalDateTime start;
    private LocalDateTime end;
    private String facility;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(username, that.username) && Objects.equals(start, that.start) && Objects.equals(end, that.end) && Objects.equals(facility, that.facility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, start, end, facility);
    }
}
