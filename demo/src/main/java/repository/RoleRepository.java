package repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import entity.RoleEntity;

@Repository
@Transactional
public class RoleRepository implements RoleRepositoryInterface {
	
	private EntityManager entityManager;
	
	private static final String GET_ROLE_BY_USER_ID = "SELECT role FROM RoleEntity role where role.id=?1";
	
	public RoleRepository(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
		}

	@Override
	public RoleEntity getRoleByUserId(int id) {
		TypedQuery<RoleEntity> query=entityManager.createQuery(GET_ROLE_BY_USER_ID, RoleEntity.class).setParameter(1, id);
		try {
			
			return query.getSingleResult();
			
			
		} catch (NoResultException e) {
			return null;
		}
		
	}
@Override
public void addSubscription(RoleEntity roleEntity) {
		
		entityManager.persist(roleEntity);
		
		
	}

}
