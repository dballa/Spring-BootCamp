package com.example.SpringBootCamp.demo.converter;

import com.example.SpringBootCamp.demo.dto.ReviewDto;
import com.example.SpringBootCamp.demo.entity.ReviewEntity;


public class ReviewConverter {
    public static ReviewDto toDto(ReviewEntity reviewEntity){
        ReviewDto toReturn=new ReviewDto();
        toReturn.setId(reviewEntity.getId());
        toReturn.setReviewInfo(reviewEntity.getReviewInfo());
        return toReturn;
    }
    public static ReviewEntity toEntity(ReviewDto reviewDto){
        ReviewEntity toReturn=new ReviewEntity();
        toReturn.setId(reviewDto.getId());
        toReturn.setReviewInfo(reviewDto.getReviewInfo());
        toReturn.setValid(reviewDto.isValid());
        return toReturn;
    }
}
