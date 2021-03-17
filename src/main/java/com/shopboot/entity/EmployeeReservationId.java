package com.shopboot.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeReservationId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "employee_service_id")
    private int employeeServiceId;

    public EmployeeReservationId() {
    }

    public EmployeeReservationId(int reservationId, int employeeServiceId) {
        this.reservationId = reservationId;
        this.employeeServiceId = employeeServiceId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getEmployeeServiceId() {
        return employeeServiceId;
    }

    public void setEmployeeServiceId(int employeeServiceId) {
        this.employeeServiceId = employeeServiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeReservationId that = (EmployeeReservationId) o;
        return reservationId == that.reservationId &&
                employeeServiceId == that.employeeServiceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, employeeServiceId);
    }
}
