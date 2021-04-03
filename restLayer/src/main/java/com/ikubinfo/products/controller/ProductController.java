package com.ikubinfo.products.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ikubinfo.products.converter.ProductConverter;
import com.ikubinfo.products.dto.MoneyExchange;
import com.ikubinfo.products.dto.ProductDto;
import com.ikubinfo.products.dto.ProductDtoForCreate;
import com.ikubinfo.products.entity.ProductEntity;

import com.ikubinfo.products.service.ProductService;

@RestController
public class ProductController {
	
	
	
	@Autowired
	ProductService productService;
	
	
	
	
	//create new product
	@PostMapping("/products")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDtoForCreate products) {
		return new ResponseEntity<>(ProductConverter.toDto(productService.createProduct(products)),HttpStatus.CREATED);
	}
	//update product 
	@PutMapping("/products")
	public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto products) {
		return new ResponseEntity<>(ProductConverter.toDto(productService.updateProduct(products)),HttpStatus.CREATED);
	}
	//delete product
	@DeleteMapping("/products")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@RequestBody ProductDto products) {
		productService.deleteProduct(products);
	    
	}
	//get products by id
	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
		return new ResponseEntity<>(ProductConverter.toDto(productService. getProductById(id)), HttpStatus.OK);
	}
	//get all products
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		
		List<ProductDto> product = new ArrayList<>(); 
		for(ProductEntity products : productService.getAllProducts()) {
			product.add(ProductConverter.toDto(products));
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	//get all products filtered by subcategory name
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> viewProducts(@RequestParam(required = false) String subcategoryName,
			@RequestParam(required = false) Boolean sortByName) {
		List<ProductDto> prod = new ArrayList<>();
		for(ProductEntity products: productService.viewProductsByAndOrdered(subcategoryName, sortByName)) {
				prod.add(ProductConverter.toDto(products));
		}
		return new ResponseEntity<>(prod, HttpStatus.OK);
	}
	@GetMapping("/testRestTemplate")
	public ResponseEntity<MoneyExchange> testRest(){
		return new ResponseEntity<>(productService.testRest(),HttpStatus.OK);
	}
}
