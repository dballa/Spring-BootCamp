package com.example.SpringBootCamp.demo.repository;


import com.example.SpringBootCamp.demo.entity.MembershipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@Repository
public class MembershippRepository {
    @Autowired
    EntityManager entityManager;
    public void createMembership(MembershipEntity membershipp){
        entityManager.persist(membershipp);
    }
    public void deleteMembershipType(long membershipp){
        entityManager.remove(membershipp);
    }
    public List<MembershipEntity> getallMemberships(){
        return entityManager.createQuery("Select membership.id,membership.membership,membership.count,membership.fee from MembershipEntity membership ", MembershipEntity.class).getResultList();
    }
}
