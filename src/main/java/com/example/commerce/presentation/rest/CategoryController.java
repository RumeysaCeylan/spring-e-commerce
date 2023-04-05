package com.example.commerce.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.service.CategoryService;

@RestController
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@PostMapping("/add")
	public long addCategory(@RequestBody CategoryDto categoryDto) {
		categoryService.add(categoryDto);
		return categoryDto.getCategoryId();
	}
	@GetMapping("/categories")
	public List<CategoryDto> getCategories() {
        return categoryService.list();
    }
}
