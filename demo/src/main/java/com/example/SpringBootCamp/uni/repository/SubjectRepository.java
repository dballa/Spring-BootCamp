package com.example.SpringBootCamp.uni.repository;

import com.example.SpringBootCamp.uni.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class SubjectRepository {

    @Autowired
    private EntityManager entityManager;

    public SubjectEntity getSubjectById(long id) {
        TypedQuery<SubjectEntity> query = entityManager.createQuery("SELECT sub from SubjectEntity sub where sub.id=?1", SubjectEntity.class).setParameter(1, id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void addSubject(SubjectEntity sub) {
        entityManager.persist(sub);
    }
}
