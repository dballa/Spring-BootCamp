package com.productReviews.productreviwes.dao.product;

import com.productReviews.productreviwes.entity.ReviewEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponseDto {

    private String name;
    private Float price;
    private String description;
    List<ReviewEntity> reviews;

}
