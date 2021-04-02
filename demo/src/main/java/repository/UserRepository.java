package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import entity.UserEntity;

@Transactional
@Repository
public class UserRepository implements UserRepositoryInterface {
	
	private EntityManager entityManager;
	
	private static final String GET_ALL_ENABLED_USERS = "SELECT user FROM UserEntity user where user.enabled = true";
	private static final String GET_ALL_ENABLED_STUDENTS = "SELECT user FROM UserEntity user where user.roleId=?1 and user.enabled = true";
	private static final String GET_USER_BY_ID = "SELECT user from UserEntity user where user.id=?1";
	private static final String USER_BY_USERNAME = "SELECT user FROM UserEntity user where user.username =?1 and user.enabled = true";
	private static final String USER_EXIST = "SELECT count(user) FROM UserEntity user where user.id =?1 and user.enabled = true";
	
		public UserRepository(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
		}
	
		@Override
		public List<UserEntity> getAllEnabledUsers() {
		TypedQuery<UserEntity> query = entityManager.createNamedQuery(GET_ALL_ENABLED_USERS, UserEntity.class);
		return query.getResultList();
		}
		
		@Override
		public List<UserEntity> getAllEnabledStudents() {
			TypedQuery<UserEntity> query = entityManager.createNamedQuery(GET_ALL_ENABLED_STUDENTS, UserEntity.class);
			return query.getResultList();
			}
		
		@Override
		public UserEntity getUserById(int id) {
		TypedQuery<UserEntity> query=entityManager.createQuery(GET_USER_BY_ID, UserEntity.class).setParameter(1, id);
		try {
			return query.getSingleResult();
			
		} catch (NoResultException e) {
			return null;
			}
		}
		@Override
		public UserEntity getUserByUsername(String username) {
			TypedQuery<UserEntity> query = entityManager.createQuery(USER_BY_USERNAME, UserEntity.class).setParameter(1,username);
			try {
				return query.getSingleResult();
			} catch (NoResultException e) {
				return null;
			}
		}
		
		@Override
		public  boolean UserExists(int id) {
			TypedQuery<Integer> query = entityManager.createQuery(USER_EXIST, Integer.class).setParameter(1,id);
			return query.getSingleResult()==1;
			
		}
		
		@Override
		public void addUser(UserEntity user) {
			
			entityManager.persist(user);
			
		}
		
		@Override
		public void updateUser(UserEntity user) {
			entityManager.merge(user);
		}
	 
		@Override
		public void softDeleteUser(UserEntity user) {
			user.setEnabled(Boolean.FALSE);
			updateUser(user);
		}

		@Override
		public void hardDeleteUser(UserEntity user) {
			entityManager.remove(user);
		}
}
