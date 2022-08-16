package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@ToString
@Entity
@Table(name = "memebership_info", schema = "public")
public class MembershipInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(nullable = false, name = "membership_type")
    private String description;
    @Column(nullable = false,name="start_date")
    private LocalDate StartDate;
    @Column(nullable = false,name="end_date")
    private LocalDate EndDate;
@Column(nullable = false,name="valid")
private Boolean Valid;
    public Long getId() {
        return id;
    }

    public Boolean getValid() {
        return Valid;
    }

    public void setValid(Boolean valid) {
        Valid = valid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }


}
