package com.countrycity.countrycity.repository.impl;

import com.countrycity.countrycity.entity.CountryEntity;
import com.countrycity.countrycity.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class CountryRepositoryImpl implements CountryRepository {

    private final EntityManager entityManager;

    private final String GET_BY_NAME = "SELECT country FROM CountryEntity country WHERE country.name = ?1";
    private final String GET_BY_ID = "SELECT country FROM CountryEntity country WHERE country.id = ?1";

    @Override
    public void save(CountryEntity country) {
        entityManager.persist(country);
    }

    @Override
    public void delete(CountryEntity country) {
        entityManager.remove(country);
    }

    @Override
    public CountryEntity update(CountryEntity country) {
        return entityManager.merge(country);
    }

    @Override
    public CountryEntity getByName(String name) {
        try {
            return entityManager.createQuery(GET_BY_NAME, CountryEntity.class).setParameter(1, name).getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public CountryEntity getById(Long id) {
        try {
            return entityManager.createQuery(GET_BY_ID, CountryEntity.class).setParameter(1, id).getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<CountryEntity> getSortedCountries(List<String> sort_by, String order) {
        String GET_ALL_SORTED = "SELECT country FROM CountryEntity country ORDER BY ";
        for(int i = 0; i < sort_by.size(); i++) {
            GET_ALL_SORTED = GET_ALL_SORTED.concat("country." + sort_by.get(i) + (i == sort_by.size() - 1 ? " " : ", "));
        }
        return entityManager.createQuery(GET_ALL_SORTED.concat(order), CountryEntity.class).getResultList();
    }
}
