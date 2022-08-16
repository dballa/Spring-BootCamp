package com.example.SpringBootCamp.demo.repository;


import com.example.SpringBootCamp.demo.entity.MembershipInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Transactional
@Repository
public class MembershipInfoRepository {
    private static final String SET_INVALID="update membership.Valid from MemebershipInfo membership set membership.valid=NO where id=?1";
    @Autowired
    EntityManager entityManager;
    public void addMemebrship(MembershipInfoEntity memebership){
        entityManager.persist(memebership);

    }
    public List<MembershipInfoEntity>getallMemberships(MembershipInfoEntity memebership){
        return entityManager.createQuery("Select membership.id,membership.description,membership.StartDate,membership.EndDate from MembershipInfoEntity membership where membership.Valid=True",MembershipInfoEntity.class).getResultList();
    }
    public void deletemembership(Long memebership){
        entityManager.remove(memebership);
    }
    public List<MembershipInfoEntity> getdatesbyId(Long memebership){
        return entityManager.createQuery("Select membership.StartDate,membership.EndDate from MembershipInfoEntity membership where membership.id=?1",MembershipInfoEntity.class).getResultList();
    }
    public void setInValid(){
         entityManager.createNamedQuery(SET_INVALID,MembershipInfoRepository.class);
    }
}
