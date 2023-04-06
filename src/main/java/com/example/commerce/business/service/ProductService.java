package com.example.commerce.business.service;

import java.util.List;

import com.example.commerce.business.dto.ProductDto;

public interface ProductService {
	void add(ProductDto productDto);
	void update(ProductDto productDto);
	void delete(long productId);
	ProductDto find(long productId);
	List<ProductDto> list();
	List<ProductDto> findByCategoryId(long categoryId);

}
