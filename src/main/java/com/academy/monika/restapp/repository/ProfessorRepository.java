package com.academy.monika.restapp.repository;

import com.academy.monika.restapp.entity.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProfessorRepository {
    @Autowired
    private EntityManager entityManager;

    public List<ProfessorEntity> getAllUsers() {
        TypedQuery<ProfessorEntity> query = entityManager.createNamedQuery("Professor.findAll", ProfessorEntity.class);
        return query.getResultList();
    }

    public ProfessorEntity getUserById(Long id) {
        TypedQuery<ProfessorEntity> query = entityManager.createQuery("SELECT professor from ProfessorEntity professor where professor.id=?1", ProfessorEntity.class).setParameter(1, id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    public void deleteUser(ProfessorEntity professor) {
        entityManager.remove(professor);
    }

    public void addUser(ProfessorEntity professor) {
        entityManager.persist(professor);
    }
}
