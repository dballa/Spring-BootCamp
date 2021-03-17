package com.shopboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private BarberShopEntity barberShop;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeServiceEntity> employeeServices;

    @ManyToMany
    @JoinTable(name = "employee_holidays",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "holiday_id"))
    private List<HolidayEntity> holidays = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "employee_working_days",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "working_days_id"))
    private List<WorkingDaysEntity> workingDays = new ArrayList<>();

}
