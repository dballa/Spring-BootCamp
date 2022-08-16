package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@ToString
@Entity
@Table(name = "motivation_quotes", schema = "public")
public class MotivationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "motivation_quote")
    private String MotivationQuote;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivationQuote() {
        return MotivationQuote;
    }

    public void setMotivationQuote(String motivationQuote) {
        MotivationQuote = motivationQuote;
    }


}
