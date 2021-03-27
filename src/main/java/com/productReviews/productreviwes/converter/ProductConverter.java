package com.productReviews.productreviwes.converter;

import com.productReviews.productreviwes.dao.product.ProductCreateDto;
import com.productReviews.productreviwes.dao.product.ProductResponseDto;
import com.productReviews.productreviwes.dao.product.ProductUpdateDto;
import com.productReviews.productreviwes.entity.ProductEntity;

public class ProductConverter {

    public static ProductEntity convertDtoToProductEntity(ProductCreateDto productCreateDto) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(productCreateDto.getName());
        newProduct.setPrice(productCreateDto.getPrice());
        newProduct.setDescription(productCreateDto.getDescription());
        return newProduct;

    }

    public static ProductResponseDto convertProductEntityToResponseDto(ProductEntity productEntity) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(productEntity.getName());
        productResponseDto.setPrice(productEntity.getPrice());
        productResponseDto.setDescription(productEntity.getDescription());
        productResponseDto.setReviews(productEntity.getReviews());
        return productResponseDto;
    }

    public static ProductEntity convertUpdateDtoToEntity(ProductUpdateDto productUpdateDto) {
        ProductEntity productToBeUpdated = new ProductEntity();
        productToBeUpdated.setId(productUpdateDto.getId());
        productToBeUpdated.setName(productUpdateDto.getName());
        productToBeUpdated.setPrice(productUpdateDto.getPrice());
        productToBeUpdated.setDescription(productUpdateDto.getDescription());
        return productToBeUpdated;
    }


}
