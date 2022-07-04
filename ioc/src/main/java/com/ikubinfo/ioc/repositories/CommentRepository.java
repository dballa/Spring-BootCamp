package com.ikubinfo.ioc.repositories;

import com.ikubinfo.ioc.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CommentRepository {
    @Autowired
    private EntityManager entityManager;

    public void addPost(CommentEntity entity) {
        entityManager.persist(entity);
    }

    public List<CommentEntity> getAllComments(int pageNumber, int pageSize) {
        return entityManager.createQuery("Select comment from CommentEntity comment", CommentEntity.class)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();

    }
}
