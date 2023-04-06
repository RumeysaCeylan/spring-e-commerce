package com.example.commerce.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.commerce.business.dto.ProductDto;
import com.example.commerce.business.service.ProductService;

public class ProductController {
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		
		this.productService = productService;
	}
	@PostMapping("/product/add")
	public long addProduct(@RequestBody ProductDto productDto) {
		productService.add(productDto);
		return productDto.getCategoryId();
	}
	@PutMapping("/product/update")
	public long updateProduct(@RequestBody ProductDto productDto) {
		productService.update(productDto);
		return productDto.getCategoryId();
	}
	@DeleteMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable("id") long productId) {
		productService.delete(productId);
	}
	@GetMapping("/product/{id}")
	public ProductDto getProductbyId(@PathVariable("id") long productId) {
		return productService.find(productId);
	}
	@GetMapping("/products/{id}")
	public List<ProductDto> getProductbyCategory(@PathVariable("id") long categoryId) {
		return productService.findByCategoryId(categoryId);
	}
	
}
