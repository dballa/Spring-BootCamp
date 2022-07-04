package com.ikubinfo.ioc.repositories;

import com.ikubinfo.ioc.entities.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;

@Repository
@Transactional
public class RoleRepository {

    @Autowired
    private EntityManager entityManager;

    public void addRole(RoleEntity role) {
        entityManager.persist(role);
    }

    public RoleEntity getRoleById(Long id) {
        return entityManager.createNamedQuery("Role.findById", RoleEntity.class).setParameter(1, id).getSingleResult();

    }


}
