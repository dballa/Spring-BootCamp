package com.productReviews.productreviwes.repository.imp;

import com.productReviews.productreviwes.entity.CommentEntity;
import com.productReviews.productreviwes.entity.ReviewEntity;
import com.productReviews.productreviwes.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@AllArgsConstructor
@Transactional
public class CommentRepositoryImp implements CommentRepository {

    private final EntityManager entityManager;

    private final String GET_BY_ID = "SELECT comment FROM CommentEntity comment WHERE comment.id = ?1";

    @Override
    public void save(CommentEntity commentEntity) {
        entityManager.persist(commentEntity);
    }

    @Override
    public void delete(CommentEntity commentEntity) {
        entityManager.remove(commentEntity);
    }

    @Override
    public CommentEntity update(CommentEntity commentEntity) {
        return entityManager.merge(commentEntity);
    }

    @Override
    public CommentEntity getById(Long id) {
        TypedQuery<CommentEntity> query = entityManager.createQuery(GET_BY_ID, CommentEntity.class).setParameter(1, id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
}
