package com.example.commerce.business.service;

import java.util.List;

import com.example.commerce.business.dto.CategoryDto;

public interface CategoryService {
	void add(CategoryDto categoryDto);
	void update(CategoryDto categoryDto);
	void delete(CategoryDto categoryDto);
	CategoryDto find(long categoryId);
	List<CategoryDto> list();
}
