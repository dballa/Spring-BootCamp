package com.productReviews.productreviwes.dao.review;

import com.productReviews.productreviwes.entity.ProductEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private String review;
    private Integer rating;
    private ProductEntity product;
}
