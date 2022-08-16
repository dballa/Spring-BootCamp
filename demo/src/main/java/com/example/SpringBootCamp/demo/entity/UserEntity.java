package com.example.SpringBootCamp.demo.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
@Table(name="user",schema="public")
@NamedQuery(name = "User.findAll", query = "SELECT user FROM UserEntity user ")


public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false,name="name")
    private String firstName;
    @Column(nullable = false,name="surname")
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String role ;
    @Column(nullable = false,name="membership_id")
    private int membershipId ;
    @Column(nullable = false, name = "username")
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

@OneToMany
@JoinTable(name = "review",joinColumns={@JoinColumn(name="review_id")},
        inverseJoinColumns = @JoinColumn(name="id"))

private List<ReviewEntity> reviewEntity;

    public List<ReviewEntity> getReviewEntity() {
        return reviewEntity;
    }

    public void setReviewEntity(ReviewEntity reviewEntity) {
        this.reviewEntity = (List<ReviewEntity>) reviewEntity;
    }
    @OneToOne
    @JoinTable(name="trainer_relations",joinColumns ={ @JoinColumn(name="user_id")},
            inverseJoinColumns= @JoinColumn(name="membership_id"))

    private TrainerRelEntity trainer;
    public TrainerRelEntity getTrainerRel() {
        return trainer;
    }

    public void setTrainerRel(TrainerRelEntity trainerRel) {
        this.trainer = trainerRel;
    }
    //@OneToOne
    //public MembershipInfoEntity membershipInfo;
    //@JoinTable(name="membership_info",joinColumns = {@JoinColumn(name="id")},inverseJoinColumns = @JoinColumn(name="membership_id"))
    //public MembershipInfoEntity getMembershipInfo() {
        //return membershipInfo;
   // }


    public CheckInEntity getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckInEntity checkIn) {
        this.checkIn = checkIn;
    }

    @OneToOne
    @JoinTable(name="check_in",joinColumns ={ @JoinColumn(name="user_id")},
            inverseJoinColumns= @JoinColumn(name="id"))
    public CheckInEntity checkIn;

}
