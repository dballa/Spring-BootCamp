package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "check_in", schema = "public")
@NoArgsConstructor
@ToString
public class CheckInEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUserId() {
        return Math.toIntExact(userId);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "user_id",nullable = false)
private Long userId;
    @Column(nullable = false)
    private int times;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }


}
