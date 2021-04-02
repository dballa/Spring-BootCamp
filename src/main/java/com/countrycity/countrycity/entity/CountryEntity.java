package com.countrycity.countrycity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@ToString
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "area")
    private Double area;

    @Column(name = "water")
    private Double waterPercentage;

    @Column(name = "population_density")
    private Double populationDensity;

    @Column(name = "gdp")
    private Double gdp;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "flag")
    private String flag;

    @Column(name = "capital")
    private String capital;

    @Column(name = "region")
    private String region;

    @Column(name = "subregion")
    private String subregion;

    @Column(name = "numeric_code")
    private String numericCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<CityEntity> cities;

}
