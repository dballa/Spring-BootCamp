package com.rest.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.rest.demo.entity.LocationEntity;
import com.rest.demo.entity.UserEntity;

@Repository
public class UserRepository {

	EntityManager em;

	public UserRepository(EntityManager em) {
		super();
		this.em = em;
	}

	private static final String GET_ALL_USERS = "FROM UserEntity";
	private static final String GET_USER_BY_ID = "FROM UserEntity ue WHERE ue.userId = :id";
	private static final String GET_ALL_USERS_BY_CITY = "FROM UserEntity ue WHERE ue.location = :location";
	private static final String GET_ALL_USERS_BY_CITY_AND_ORDERED = "FROM UserEntity ue WHERE ue.location = :location ORDER BY ue.username";
	private static final String GET_ALL_USERS_ORDERED = "FROM UserEntity ue ORDER BY ue.username";
	private static final String GET_USER_BY_LOCATION= "FROM UserEntity ue WHERE ue.location = :location";
	
	
	public List<UserEntity> getUsers() {
		return em.createQuery(GET_ALL_USERS, UserEntity.class).getResultList();
	}

	public void insertUser(UserEntity user) {
		em.persist(user);
	}

	public UserEntity getUserById(int id) {
		try {
			return em.createQuery(GET_USER_BY_ID, UserEntity.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void updateUser(UserEntity userToAdd) {
		em.merge(userToAdd);
	}

	public void deleteUser(UserEntity userToAdd) {
		em.remove(userToAdd);
	}

	public List<UserEntity> getFilterByCity(LocationEntity city) {
		return em.createQuery(GET_ALL_USERS_BY_CITY, UserEntity.class).setParameter("location", city).getResultList();
	}

	public List<UserEntity> getUsersOrderedBy() {
		return em.createQuery(GET_ALL_USERS_ORDERED, UserEntity.class).getResultList();
	}

	public List<UserEntity> getFilteredAndOrdered(LocationEntity city) {
		return em.createQuery(GET_ALL_USERS_BY_CITY_AND_ORDERED, UserEntity.class).setParameter("location", city).getResultList();
	}

	public boolean getUserByLocation(LocationEntity locationToDelete) {
		return em.createQuery(GET_USER_BY_LOCATION,UserEntity.class).setParameter("location", locationToDelete)!=null;
	}
}
