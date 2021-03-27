package com.productReviews.productreviwes.service;

import com.productReviews.productreviwes.entity.ReviewEntity;

public interface ReviewService {

    void save(ReviewEntity reviewEntity, Long product_id);
    void delete(Long id);
    ReviewEntity update(ReviewEntity reviewEntity, Long product_id);

}
