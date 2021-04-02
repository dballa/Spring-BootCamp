package com.countrycity.countrycity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private Double area;

    @Column(name = "population_density")
    private Double populationDensity;

    @Column(name = "pstal_code")
    private String postalCode;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JsonBackReference
    private CountryEntity country;

}
