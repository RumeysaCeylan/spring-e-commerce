package com.example.commerce.business.dto;

import java.util.List;

public class CategoryDto {
	private long categoryId;
	private String categoryName;
	private List<ProductDto> products;

	public CategoryDto() {}

	public CategoryDto(long categoryId, String categoryName, List<ProductDto> products) {
	        this.categoryId = categoryId;
	        this.categoryName = categoryName;
	        this.products = products;
	}

	    // getters and setters
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
}
