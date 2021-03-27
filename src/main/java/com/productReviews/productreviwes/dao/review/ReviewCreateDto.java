package com.productReviews.productreviwes.dao.review;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewCreateDto {
    private String review;
    private Integer rating;
    private Long productId;
}
