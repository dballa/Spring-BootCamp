package com.example.SpringBootCamp.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@ToString
@Data
@Table(name = "membership", schema = "public")
public class MembershipEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String membership;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int fee;


    @OneToOne

    @JoinTable(name = "membership_info", joinColumns = {@JoinColumn(name = "membership_type")}, inverseJoinColumns = @JoinColumn(name = "membership"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    public MembershipInfoEntity membershipInfo;

    public MembershipInfoEntity getMembershipInfo() {
        return membershipInfo;
    }


//    @OneToOne
//    @JoinTable(name = "check_in", joinColumns = {@JoinColumn(name = "count")}, inverseJoinColumns = @JoinColumn(name = "count"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    public CheckInEntity checkIn;

}


