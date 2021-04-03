package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.UserEntity;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	private EntityManager entityManager;

	public UserEntity findByUsername(String username) {
		return new UserEntity(1, "klevis", "dasda", 3, "ADMIN", "admin123",
				"$2a$10$Y3h3LZs51ZVuGeD8npzYUuTihKA6VI2tkBVt43nJUxeucA92Jh4eK");
	}

}
