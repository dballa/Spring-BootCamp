package com.example.SpringBootCamp.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
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
}
