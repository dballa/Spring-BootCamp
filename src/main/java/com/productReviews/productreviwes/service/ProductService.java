package com.productReviews.productreviwes.service;

import com.productReviews.productreviwes.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    void save(ProductEntity productEntity);
    List<ProductEntity> all();
    ProductEntity getById(Long id);
    void delete(Long id);
    ProductEntity update(ProductEntity productEntity);


}
