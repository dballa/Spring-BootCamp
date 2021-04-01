package com.rest.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.rest.demo.entity.LocationEntity;

@Repository
public class LocationRepository {

	EntityManager em;

	public LocationRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private static final String GET_LOCATION_BY_ID = "FROM LocationEntity le WHERE le.locationId = :id ";
	private static final String GET_LOCATIONS = "FROM LocationEntity";
	private static final String GET_CITY_FROM_LOCATION_ID = "FROM LocationEntity le WHERE le.city = :city";

	public List<LocationEntity> getLocations() {
		return em.createQuery(GET_LOCATIONS, LocationEntity.class).getResultList();
	}

	public LocationEntity getLocationById(int location) {
		try {
			return em.createQuery(GET_LOCATION_BY_ID, LocationEntity.class).setParameter("id", location)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void insertLocation(LocationEntity location) {
		em.persist(location);
	}

	public LocationEntity getLocationByCity(String city) {
		try {
			return em.createQuery(GET_CITY_FROM_LOCATION_ID, LocationEntity.class).setParameter("city", city)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void updateLocation(LocationEntity locationCheck) {
		em.merge(locationCheck);

	}
	
	public void deleteLocation(LocationEntity locationCheck) {
		em.remove(locationCheck);

	}

}
