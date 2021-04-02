package com.academy.monika.restapp.repository;

import com.academy.monika.restapp.entity.SubjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SubjectRepository {

    @Autowired
    private EntityManager entityManager;
    public SubjectRepository(EntityManager em) {
        super();
        this.entityManager = em;
    }


    private static final String GET_SUBJECTS_ORDERED_BY_NAME = "SELECT subject FROM SubjectEntity subject ORDER BY subject.name";
    private static final String GET_SUBJECTS_FILTERED_BY_ACTIVE_STATUS_AND_ORDERED_BY_NAME = "SELECT subject FROM SubjectEntity subject WHERE subject.active = :active ORDER BY subject.name";


    public SubjectEntity getSubjectById(long id) {
        TypedQuery<SubjectEntity> query = entityManager.createQuery("SELECT sub from SubjectEntity sub where sub.id=?1", SubjectEntity.class).setParameter(1, id);
        try {
            System.out.println(query.getSingleResult().getName());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void addSubject(SubjectEntity sub) {
        entityManager.persist(sub);
    }
    public void deleteSubject(SubjectEntity sub) {
        entityManager.remove(sub);
    }
    public List<SubjectEntity> getList() {

        TypedQuery<SubjectEntity> query = entityManager.createNamedQuery("subject.findAll", SubjectEntity.class);
        return query.getResultList();    }

    public List<SubjectEntity> getActiveList(Boolean active) {
        TypedQuery<SubjectEntity> query = entityManager.createQuery("SELECT subject from SubjectEntity subject where subject.active=?1 ", SubjectEntity.class).setParameter(1, active);
        return query.getResultList();
    }
    public List<SubjectEntity> getOrderedList() {
        return entityManager.createQuery(GET_SUBJECTS_ORDERED_BY_NAME, SubjectEntity.class).getResultList();
    }
    public List<SubjectEntity> getFilteredAndOrderedList(Boolean active) {
        return entityManager.createQuery(GET_SUBJECTS_FILTERED_BY_ACTIVE_STATUS_AND_ORDERED_BY_NAME, SubjectEntity.class).setParameter("active", active).getResultList();
    }

}
