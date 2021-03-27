package com.productReviews.productreviwes.service.imp;

import com.productReviews.productreviwes.entity.ProductEntity;
import com.productReviews.productreviwes.exception.ProductException;
import com.productReviews.productreviwes.repository.ProductRepository;
import com.productReviews.productreviwes.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void save(ProductEntity productEntity) {
        if(Objects.isNull(productRepository.getByName(productEntity.getName()))) {
            productRepository.save(productEntity);
        }else {
            throw new ProductException("Product with given name already exists!");
        }
    }

    @Override
    public List<ProductEntity> all() {
        return productRepository.all();
    }

    @Override
    public ProductEntity getById(Long id) {
        ProductEntity productWithId = productRepository.getById(id);
        if(Objects.isNull(productWithId)) {
            throw new ProductException("Product with given id does not exist!");
        }
        return productWithId;
    }

    @Override
    public void delete(Long id) {
        ProductEntity productToBeDeleted = productRepository.getById(id);
        if(Objects.isNull(productToBeDeleted)){
            throw new ProductException("Product does not exist!");
        }else {
            productRepository.delete(productToBeDeleted);
        }
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        if(Objects.isNull(productRepository.getById(productEntity.getId()))){
            throw new ProductException("Product does not exist!");
        }else if(!Objects.isNull(productRepository.getByName(productEntity.getName()))){
            throw new ProductException("Product with given name already exist!");
        } else {
            return productRepository.update(productEntity);
        }
    }
}
