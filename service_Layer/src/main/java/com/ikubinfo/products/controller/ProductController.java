package com.ikubinfo.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.products.converter.ProductConverter;
import com.ikubinfo.products.dto.ProductDto;
import com.ikubinfo.products.dto.ProductDtoForCreate;
import com.ikubinfo.products.entity.ProductEntity;
import com.ikubinfo.products.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/createProduct")
	public ProductDto createProduct(@RequestBody ProductDtoForCreate products) {
		
		return ProductConverter.toDto(productService.createProduct(products));
	}
	@PutMapping("/updateProduct")
	public ProductDto updateProduct(@RequestBody ProductDto products) {
		return ProductConverter.toDto(productService.updateProduct(products));
	}
	@DeleteMapping("deleteProduct")
	public void deleteProduct(@RequestBody ProductDto products) {
		productService.deleteProduct(products);
	}
	@GetMapping("/findProduct/{id}")
	public ProductDto getProductById(@PathVariable int id) {
		return ProductConverter.toDto(productService. getProductById(id));
	}
	@GetMapping("/allProducts")
	public List<ProductDto> getAllProducts(){
		
		List<ProductDto> product = new ArrayList<>(); 
		for(ProductEntity products : productService.getAllProducts()) {
			product.add(ProductConverter.toDto(products));
		}
		return product;
	}
}
