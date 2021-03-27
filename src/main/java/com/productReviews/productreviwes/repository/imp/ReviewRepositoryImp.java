package com.productReviews.productreviwes.repository.imp;

import com.productReviews.productreviwes.entity.ReviewEntity;
import com.productReviews.productreviwes.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@AllArgsConstructor
@Transactional
public class ReviewRepositoryImp implements ReviewRepository {

    private final EntityManager entityManager;
    private final String GET_BY_ID = "SELECT review FROM ReviewEntity review LEFT JOIN FETCH review.comments WHERE review.id = ?1";

    @Override
    public void save(ReviewEntity reviewEntity) {
        entityManager.persist(reviewEntity);
    }

    @Override
    public void delete(ReviewEntity reviewEntity) {
        entityManager.remove(reviewEntity);
    }

    @Override
    public ReviewEntity update(ReviewEntity reviewEntity) {
        return entityManager.merge(reviewEntity);
    }

    @Override
    public ReviewEntity getById(Long id) {
        TypedQuery<ReviewEntity> query = entityManager.createQuery(GET_BY_ID, ReviewEntity.class).setParameter(1, id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
}
