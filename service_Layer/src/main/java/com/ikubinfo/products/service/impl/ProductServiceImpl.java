package com.ikubinfo.products.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikubinfo.products.converter.ProductConverter;
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

	


}
