package com.ikubinfo.products.service;

import java.util.List;

import com.ikubinfo.products.dto.ProductDto;
import com.ikubinfo.products.dto.ProductDtoForCreate;
import com.ikubinfo.products.entity.ProductEntity;

public interface ProductService {
	
	public List<ProductEntity> getAllProducts();
	
	public ProductEntity getProductById(int id);
	
	public ProductEntity createProduct(ProductDtoForCreate products);
	
	public ProductEntity updateProduct(ProductDto products);
	
	public void deleteProduct(ProductDto products);
	
	

}
