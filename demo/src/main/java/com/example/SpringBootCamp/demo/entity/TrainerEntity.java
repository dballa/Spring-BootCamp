package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@ToString
@Entity
@Table(name="trainer",schema="public")
@NamedQuery(name = "Trainer.findAll", query = "SELECT trainer FROM TrainerEntity trainer ")
public class TrainerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name="name")
    private String firstName;
    @Column(nullable = false,name="surname")
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
@Column(nullable = false)
private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //shto rershtin count
    //i jep mundsin userit te zgjedh
    //ns filan zgjidhet +1 rreshtin
    //heren tjt ben printimin vetem te njerzve qe e kan deri ne 3
    //fshi relationship ssapo tmbaroj membershipi,bej dekrementin (delete rreshtin where user id=?,-1 rrreshtin where id e trainerit ne trainer=id e trainerit ne trainer relations)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToOne
    @JoinTable(name = "trainer_relations",joinColumns={@JoinColumn(name="trainer_id")},
            inverseJoinColumns = @JoinColumn(name="id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TrainerRelEntity trainerRel;

    public TrainerRelEntity getTrainerRel() {
        return trainerRel;
    }

    public void setTrainerRel(TrainerRelEntity trainerRel) {
        this.trainerRel = trainerRel;
    }
}
