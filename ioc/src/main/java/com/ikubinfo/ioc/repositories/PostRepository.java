package com.ikubinfo.ioc.repositories;

import com.ikubinfo.ioc.entities.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class PostRepository {
    @Autowired
    private EntityManager entityManager;


    public void addPost(PostEntity entity) {
        entityManager.persist(entity);
    }

    public PostEntity getPostById(Long id) {
        return entityManager.createNamedQuery("Post.findById", PostEntity.class).setParameter(1, id).getSingleResult();

    }
    public List<PostEntity>getAll(){
        return entityManager.createQuery("Select post from PostEntity post",PostEntity.class).getResultList();
    }


}
