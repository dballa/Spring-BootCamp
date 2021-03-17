package com.shopboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "employee_service_reservation", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeServiceReservationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EmployeeReservationId id;

    @Column(name = "duration")
    private int duration;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "valid")
    private boolean valid;

}
