package com.book.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.book.entity.PublisherEntity;

import java.util.List;

@Transactional
@Repository
public class PublisherRepository {
    private EntityManager entityManager;

    public PublisherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    private static final String PUBLISHER_BY_ID ="select publisher from PublisherEntity publisher where publisher.id=?1";

    public List<PublisherEntity>getAllPublisher() {
        TypedQuery<PublisherEntity> query = entityManager.createNamedQuery("Publisher.findAll", PublisherEntity.class);
        return query.getResultList();
    }
    
    public  PublisherEntity getPublisherById(long id){
        TypedQuery<PublisherEntity> query=entityManager.createQuery(PUBLISHER_BY_ID,PublisherEntity.class).setParameter(1,id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("No results");
            return null;
        }
    }
    public void addPublisher(PublisherEntity publisher){
        entityManager.persist(publisher);
    }
    public PublisherEntity updatePublisher(PublisherEntity publisher) {
		return entityManager.merge(publisher);
	}
    public void deletePublisher(PublisherEntity publisher){
        entityManager.remove(publisher);
    }
    
    public List<PublisherEntity> searchByName(String name) {
    	name = "%" + name + "%";
 		TypedQuery<PublisherEntity> query = entityManager.createQuery("SELECT publisher from PublisherEntity publisher where publisher.name like ?1",PublisherEntity.class).setParameter(1, name);
 		return query.getResultList();
 	}
    
    public List<PublisherEntity> searchByAddress(String address) {
    	address = "%" + address + "%";
 		TypedQuery<PublisherEntity> query = entityManager.createQuery("SELECT publisher from PublisherEntity publisher where publisher.address like ?1",PublisherEntity.class).setParameter(1, address);
 		return query.getResultList();
 	}
    
}

