package com.example.SpringBootCamp.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCamp.demo.entity.UserEntity;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	private EntityManager entityManager;
	
	public List<UserEntity> getAllUsers() {
		TypedQuery<UserEntity> query = entityManager.createNamedQuery("User.findAll", UserEntity.class);
		return query.getResultList();
	}
	public UserEntity getUserById(Long id) {
		TypedQuery<UserEntity> query=entityManager.createQuery("SELECT user from UserEntity user where user.id=?1", UserEntity.class).setParameter(1, id);
		try {
			return query.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}
	public void deleteUser(UserEntity user) {
		entityManager.remove(user);
	}
	public void addUser(UserEntity user) {
		
		entityManager.persist(user);
		
		
	}
	public List<UserEntity> getFilterByName(String name) {
		TypedQuery<UserEntity> query = entityManager.createQuery("SELECT user from UserEntity user where user.firstName=?1", UserEntity.class).setParameter(1, name);
		return query.getResultList();
	}

}
