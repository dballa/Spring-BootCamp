package com.example.SpringBootCamp.demo.repository;

import com.example.SpringBootCamp.demo.entity.CheckInEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInRepository extends JpaRepository<CheckInEntity,Long> {
    @Query("SELECT SUM(c.times) FROM CheckInEntity c where c.id=?1")
    Float selectTotals(long userId);
    @Query("Update MembershipInfoEntity memb set memb.Valid=false where memb.id=?1")
    void updateValidity(long userId);


}
