package com.ikubinfo.reservation.request;

import java.time.LocalDateTime;

public class ReservationCreateRequest {
    private String username;
    private String shopServiceType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopServiceType() {
        return shopServiceType;
    }

    public void setShopServiceType(String shopServiceType) {
        this.shopServiceType = shopServiceType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
