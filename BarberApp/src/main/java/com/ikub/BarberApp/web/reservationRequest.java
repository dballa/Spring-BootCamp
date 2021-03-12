package com.ikub.BarberApp.web;

import com.ikub.BarberApp.model.TypeOfReservation;

import java.util.Date;
import java.util.List;

public class reservationRequest {
    private String name;
    private List<TypeOfReservation> type;
    private Date startDate;
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeOfReservation> getType() {
        return type;
    }

    public void setType(List<TypeOfReservation> type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
