package com.shopboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barber_shop", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BarberShopEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "code")
    private String code;


    @Column(name = "longitude")
    private BigInteger longitude;


    @Column(name = "latitude")
    private BigInteger latitude;


    @Column(name = "description")
    private String description;


    @Column(name = "email")
    private String email;


    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "valid")
    private boolean valid;

    @OneToMany(mappedBy = "barberShop")
    private List<EmployeeEntity> employees;

    @OneToMany(mappedBy = "barberShop")
    private List<ProductEntity> products;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "shop_holidays",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "holiday_id"))
    private List<HolidayEntity> holidays = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "shop_service",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<ServiceEntity> services = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "shop_working_days",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "working_days_id"))
    private List<WorkingDaysEntity> workingDays = new ArrayList<>();
 
}
