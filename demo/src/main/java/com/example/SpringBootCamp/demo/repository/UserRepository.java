package com.example.SpringBootCamp.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootCamp.demo.dto.UserFilter;
import com.example.SpringBootCamp.demo.entity.UserEntity;
import com.example.SpringBootCamp.demo.exceptions.CustomUserException;

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
		TypedQuery<UserEntity> query = entityManager
				.createQuery("SELECT user from UserEntity user where user.id=?1", UserEntity.class).setParameter(1, id);
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

	public List<UserEntity> getUsers(UserFilter filter) {
		// Starting query
		String queryString = "SELECT user from UserEntity user where 1=1 ";

		// Creating query string for all filtrabl
		if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
			queryString = queryString + "and user.firstName=:firstName ";
		}
		if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
			queryString = queryString + " and user.lastName=:lastName ";
		}
		if (filter.getAge() != null) {
			queryString = queryString + " and user.age=:age ";
		}

		// setting sort field
		if (filter.getSortBy() != null && !filter.getSortBy().isEmpty()) {
			if (filter.getSortBy().equals("firstName") || filter.getSortBy().equals("lastName")
					|| filter.getSortBy().equals("age")) {
				queryString = queryString + " order by user." + filter.getSortBy();
			} else {
				throw new CustomUserException("Sort by must be firstName , lastName or age");
			}
		}
		// setting order
		if (filter.getOrder() != null && !filter.getSortBy().isEmpty() && filter.getSortBy() != null
				&& !filter.getSortBy().isEmpty()) {
			if (filter.getOrder().toUpperCase().equals("ASC") || filter.getOrder().toUpperCase().equals("DESC")) {
				queryString = queryString + " " + filter.getOrder();
			} else {
				throw new CustomUserException("Order  must be ASC or DESC");
			}
		}

		TypedQuery<UserEntity> query = entityManager.createQuery(queryString, UserEntity.class);

      //Setting parameters
		if (filter.getFirstName() != null && !filter.getFirstName().isEmpty()) {
			query.setParameter("firstName", filter.getFirstName());

		}
		if (filter.getLastName() != null && !filter.getLastName().isEmpty()) {
			query.setParameter("lastName", filter.getLastName());
		}
		if (filter.getAge() != null) {
			query.setParameter("age", filter.getAge());
		}

		return query.getResultList();
	}

}
