package com.productReviews.productreviwes.service;

import com.productReviews.productreviwes.entity.CommentEntity;

public interface CommentService {

    void save(CommentEntity commentEntity, Long reviewId);
    void delete(Long id);
    CommentEntity update(CommentEntity commentEntity, Long reviewId);

}
