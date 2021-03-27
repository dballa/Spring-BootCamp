package com.productReviews.productreviwes.repository;

import com.productReviews.productreviwes.entity.CommentEntity;

public interface CommentRepository {

    void save(CommentEntity commentEntity);
    void delete(CommentEntity commentEntity);
    CommentEntity update(CommentEntity commentEntity);
    CommentEntity getById(Long id);

}
