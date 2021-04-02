package com.countrycity.countrycity.repository.impl;

import com.countrycity.countrycity.entity.CityEntity;
import com.countrycity.countrycity.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
@Transactional
public class CityRepositoryImpl implements CityRepository {

    private final EntityManager entityManager;
    private final String GET_BY_ID = "SELECT city FROM CityEntity city WHERE city.id = ?1";
    private final String GET_ALL = "SELECT city FROM CityEntity city";
    private final String GET_BY_NAME = "SELECT city FROM CityEntity city WHERE city.name = ?1";


    @Override
    public void save(CityEntity city) {
        entityManager.persist(city);
    }

    @Override
    public void delete(CityEntity city) {
        entityManager.remove(city);
    }

    @Override
    public CityEntity update(CityEntity city) {
        return entityManager.merge(city);
    }

    @Override
    public List<CityEntity> getAll() {
        return entityManager.createQuery(GET_ALL, CityEntity.class).getResultList();
    }

    @Override
    public CityEntity getById(Long id) {
        try {
            return entityManager.createQuery(GET_BY_ID, CityEntity.class).setParameter(1, id).getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CityEntity> getByName(String name) {
        return entityManager.createQuery(GET_BY_NAME, CityEntity.class).setParameter(1, name).getResultList();
    }

}
