package com.ikubacademy.homework.service.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "holiday")
public class HolidayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int daySpan;

    @ManyToOne
    @JoinColumn(name = "employee_id" , referencedColumnName = "id")
    private EmployeeEntity employeeEntity;
}
