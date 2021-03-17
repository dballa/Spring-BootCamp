package com.shopboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

import java.time.LocalDateTime;


@Entity
@Table(name = "employee_service", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "price")
    private BigInteger price;


    @Column(name = "duration")
    private int duration;


    @Column(name = "valid")
    private boolean valid;

    @Column(name = "created_on")
    private LocalDateTime createdOn;


    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ServiceEntity service;

}
