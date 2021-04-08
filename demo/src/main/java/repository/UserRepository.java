package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import dto.UserFilter;
import entity.UserEntity;
import exceptions.CustomUserException;

@Transactional
@Repository
public class UserRepository implements UserRepositoryInterface {
	
	private EntityManager entityManager;
	
	private static final String GET_ALL_ENABLED_USERS = "SELECT user FROM UserEntity user where user.enabled = true";
	private static final String GET_ALL_ENABLED_STUDENTS = "SELECT user FROM UserEntity user where user.roleId=?1 and user.enabled = true";
	private static final String GET_USER_BY_ID = "SELECT user from UserEntity user where user.id=?1";
	private static final String USER_BY_USERNAME = "SELECT user FROM UserEntity user where user.username =?1 and user.enabled = true";
	private static final String USER_EXIST = "SELECT count(user) FROM UserEntity user where user.id =?1 and user.enabled = true";
	private static final String USER_BY_NAME = "SELECT user from UserEntity user where user.firstName=?1 and user.enabled = true";
	
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

		@Override
		public List<UserEntity> getUserByName(String name) {
			TypedQuery<UserEntity> query = entityManager.createQuery(USER_BY_NAME, UserEntity.class).setParameter(1, name);
			return query.getResultList();
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
