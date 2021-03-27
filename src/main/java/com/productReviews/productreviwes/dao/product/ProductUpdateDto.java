package com.productReviews.productreviwes.dao.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductUpdateDto {

    private Long id;
    private String name;
    private Float price;
    private String description;

}
