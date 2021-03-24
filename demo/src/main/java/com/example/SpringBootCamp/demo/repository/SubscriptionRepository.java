package com.example.SpringBootCamp.demo.repository;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCamp.demo.entity.SubscriptionEntity;
import com.example.SpringBootCamp.demo.entity.UserEntity;

@Repository
@Transactional
public class SubscriptionRepository {

	@Autowired
	private EntityManager entityManager;
	
	public SubscriptionEntity getSubscriptionById(long id) {
		TypedQuery<SubscriptionEntity> query=entityManager.createQuery("SELECT sub from SubscriptionEntity sub where sub.id=?1", SubscriptionEntity.class).setParameter(1, id);
		try {
			
			return query.getSingleResult();
			
			
		} catch (NoResultException e) {
			return null;
		}
		
	}
public void addSubscription(SubscriptionEntity sub) {
		
		entityManager.persist(sub);
		
		
	}
}
