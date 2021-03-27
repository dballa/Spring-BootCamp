package com.productReviews.productreviwes.converter;

import com.productReviews.productreviwes.dao.review.ReviewCreateDto;
import com.productReviews.productreviwes.dao.review.ReviewResponseDto;
import com.productReviews.productreviwes.dao.review.ReviewUpdateDto;
import com.productReviews.productreviwes.entity.ReviewEntity;

public class ReviewConverter {

    public static ReviewEntity convertCreateDtoToReviewEntity(ReviewCreateDto reviewCreateDto) {
        ReviewEntity reviewToBeAdded = new ReviewEntity();
        reviewToBeAdded.setRating(reviewCreateDto.getRating());
        reviewToBeAdded.setReview(reviewCreateDto.getReview());
        return reviewToBeAdded;
    }

    public static ReviewResponseDto convertEntityToReviewResponseDto(ReviewEntity reviewEntity) {
        ReviewResponseDto reviewResponse = new ReviewResponseDto();
        reviewResponse.setReview(reviewEntity.getReview());
        reviewResponse.setRating(reviewEntity.getRating());
        reviewResponse.setProduct(reviewEntity.getProduct());
        return reviewResponse;
    }

    public static ReviewEntity convertUpdateDtoToEntity(ReviewUpdateDto reviewUpdateDto) {
        ReviewEntity reviewToBeUpdated = new ReviewEntity();
        reviewToBeUpdated.setId(reviewUpdateDto.getId());
        reviewToBeUpdated.setReview(reviewUpdateDto.getReview());
        reviewToBeUpdated.setRating(reviewUpdateDto.getRating());
        return reviewToBeUpdated;
    }

}
