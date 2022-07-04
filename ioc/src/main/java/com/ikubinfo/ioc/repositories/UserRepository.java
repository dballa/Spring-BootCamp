package com.ikubinfo.ioc.repositories;

import com.ikubinfo.ioc.entities.RoleEntity;
import com.ikubinfo.ioc.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

	private EntityManager entityManager;

	private RoleRepository roleRepository;


	public UserRepository(EntityManager entityManager, RoleRepository roleRepository) {
		super();
		this.entityManager = entityManager;
		this.roleRepository = roleRepository;
	}

	private static final String USER_BY_USERNAME = "SELECT user FROM UserEntity user where user.username =?1 ";

	private static final String ALL_USERS_FETCHED = "SELECT user FROM UserEntity user LEFT JOIN FETCH user.roles";
	
	public List<UserEntity> getAllUsers() {
		TypedQuery<UserEntity> query = entityManager.createNamedQuery("User.findAll", UserEntity.class);
		return query.getResultList();
	}

	public List<UserEntity> getAllUsersFetched() {
		TypedQuery<UserEntity> query = entityManager.createQuery(ALL_USERS_FETCHED, UserEntity.class);
		return query.getResultList();
	}
	
	public UserEntity getUserByUsername(String username) {
		TypedQuery<UserEntity> query = entityManager.createQuery(USER_BY_USERNAME, UserEntity.class).setParameter(1,username);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public void addUser(UserEntity user) {
		entityManager.persist(user);
	}

	public void updateUser(UserEntity user) {
		entityManager.merge(user);
	}

	public void softDeleteUser(UserEntity user) {
		user.setValid(Boolean.FALSE);
		updateUser(user);
	}

	public void hardDeleteUser(UserEntity user) {
		entityManager.remove(user);
	}

	public void addRoleToUser(String username, Long roleId){
		UserEntity user = getUserByUsername(username);
		RoleEntity role = roleRepository.getRoleById(roleId);
		user.getRoles().add(role);
		entityManager.merge(user);
	}
}
