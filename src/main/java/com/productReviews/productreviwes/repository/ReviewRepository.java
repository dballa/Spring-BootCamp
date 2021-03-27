package com.productReviews.productreviwes.repository;

import com.productReviews.productreviwes.entity.ReviewEntity;

import java.util.List;

public interface ReviewRepository {

    void save(ReviewEntity reviewEntity);
    void delete(ReviewEntity reviewEntity);
    ReviewEntity update(ReviewEntity reviewEntity);
    ReviewEntity getById(Long id);

}
