package com.productReviews.productreviwes.repository;
import com.productReviews.productreviwes.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {

    void save(ProductEntity productEntity);
    List<ProductEntity> all();
    ProductEntity getById(Long id);
    ProductEntity getByName(String name);
    void delete(ProductEntity productEntity);
    ProductEntity update(ProductEntity productEntity);


}
