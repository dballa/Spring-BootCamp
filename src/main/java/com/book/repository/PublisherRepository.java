package com.book.repository;



import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.book.Entity.PublisherEntity;

import java.util.List;

@Repository
public class PublisherRepository {
    private EntityManager entityManager;

    public PublisherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    private static final String PUBLISHER_BY_ID ="select publisher from PublisherEntity where publisher.publisher_id=?1";

    public List<PublisherEntity>getAllPublisher() {
        TypedQuery<PublisherEntity> query = entityManager.createQuery("Publisher.findAll", PublisherEntity.class);
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
    public void updatePublisher(PublisherEntity publisher){
        entityManager.merge(publisher);
    }
    public void deletePublisher(PublisherEntity publisher){
        entityManager.remove(publisher);
    }
}

