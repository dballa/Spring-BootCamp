package com.ikubinfo.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpMethod;


import com.ikubinfo.products.converter.ProductConverter;
import com.ikubinfo.products.dto.MoneyExchange;
import com.ikubinfo.products.dto.ProductDto;
import com.ikubinfo.products.dto.ProductDtoForCreate;
import com.ikubinfo.products.entity.ProductEntity;
import com.ikubinfo.products.entity.SubcategoryEntity;
import com.ikubinfo.products.exception.ProductException;
import com.ikubinfo.products.repository.ProductRepository;
import com.ikubinfo.products.repository.SubcategoryRepository;
import com.ikubinfo.products.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	RestTemplate restTemplate;
	
	ProductRepository productRepository;
	SubcategoryRepository subcategoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository, SubcategoryRepository subcategoryRepository) {
		super();
		this.productRepository = productRepository;
		this.subcategoryRepository = subcategoryRepository;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		
		return productRepository.getAllProducts();
	}

	@Override
	public ProductEntity getProductById(int id) {
		
		ProductEntity existingProduct= productRepository.getProductById(id);
		if(existingProduct ==  null) {
			throw new ProductException("Product doesn't exist!");
		}else {
			return existingProduct;
		}
	}

	@Override
	public ProductEntity createProduct(ProductDtoForCreate products) {
		if (products != null) {
			if(products.getName()!=null) {
							if(products.getPrice()>0){
									SubcategoryEntity subcategoryFound = subcategoryRepository.getSubcategoryById(products.getSubcategory());
									if(subcategoryFound != null){
										ProductEntity productsToAdd = ProductConverter.toEntityForCreate(products, subcategoryFound);
										productRepository.addProduct(productsToAdd);
										return productsToAdd;
									}else {
										throw new ProductException("Subcategory is mandatory");
									}

							}else {
								throw new ProductException("Price must be greater than 0");
							}
	
				} else {
					throw new ProductException("Name is mandatory");
				}
			
		}
		return null;
		
	}

	@Override
	public ProductEntity updateProduct(ProductDto products) {
		
		ProductEntity existingProduct= productRepository.getProductById(products.getId());
		if (products.getName() != null) {
			if (products.getPrice() > 0) {
				SubcategoryEntity subcategoryFound = subcategoryRepository
						.getSubcategoryById(products.getSubcategory().getId());
				if (subcategoryFound != null) {
					ProductEntity productToUpdate = ProductConverter.toEntity(products);
					existingProduct.setName(productToUpdate.getName());
					existingProduct.setDescription(productToUpdate.getDescription());
					existingProduct.setPrice(productToUpdate.getPrice());
					productRepository.updateProduct(existingProduct);
					return existingProduct;
				} else {
					throw new ProductException("Subcategory is mandatory");
				}
			} else {
				throw new ProductException("Price must be greater than 0");
			}
		} else {
			throw new ProductException("Name is mandatory");
		}
}

	@Override
	public void deleteProduct(ProductDto products) {
		
		if (productRepository.getProductById(products.getId()) == null) {
			throw new ProductException("This product doesn't exists");
		} else {
			productRepository.deleteProduct(ProductConverter.toEntity(products));
		}
		
	}
	public List<ProductEntity> viewProductsByAndOrdered(String name,String field, Boolean sortByName, String order) {
		if(name!=null && !name.isEmpty()) {
			if(sortByName) {
				SubcategoryEntity subName = subcategoryRepository.getSubcategoryByName(name);
				return productRepository.getFilteredAndOrdered(subName);
			}else {
				SubcategoryEntity subName = subcategoryRepository.getSubcategoryByName(name);
				return productRepository.getFilterBySubcategory(subName);
			}
			
		}else if(field!=null && !field.isEmpty()) {
			return productRepository.getProductsSortedByFieldAndOrder(field, order);
		}else {
			if(sortByName) {
				return productRepository.getProductsOrderedBy();
			}else{
				return productRepository.getAllProducts();
			}
		}
	}

	@Override
	public List<ProductEntity> viewProductsByAndOrdered(String name, Boolean sortByName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MoneyExchange testRest() {
		ResponseEntity<MoneyExchange> response=restTemplate.exchange("https://api.fastforex.io/fetch-all?api_key=4c307c7f38-5109e2c3d6-qqy9yy", HttpMethod.GET,null,MoneyExchange.class);

		MoneyExchange a = response.getBody();
		return a;
	}
	


}
