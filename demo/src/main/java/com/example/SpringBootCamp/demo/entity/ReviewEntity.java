package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@ToString
@Entity
@Table(name = "review", schema = "public")
public class ReviewEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column(nullable = false, name = "review_info")
    private String ReviewInfo;
    @Column(name = "valid",nullable = false)
    private boolean valid;


    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewInfo() {
        return ReviewInfo;
    }

    public void setReviewInfo(String reviewInfo) {
        ReviewInfo = reviewInfo;
    }

}
