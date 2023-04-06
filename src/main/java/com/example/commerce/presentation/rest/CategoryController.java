package com.example.commerce.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.service.CategoryService;

@RestController

public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@PostMapping("/category/add")
	public long addCategory(@RequestBody CategoryDto categoryDto) {
		categoryService.add(categoryDto);
		return categoryDto.getCategoryId();
	}
	@PutMapping("/category/update")
	public long updateCategory(@RequestBody CategoryDto categoryDto) {
		categoryService.update(categoryDto);
		return categoryDto.getCategoryId();
	}
	@DeleteMapping("/category/delete/{id}")
	public void deleteCategory(@PathVariable("id") long categoryId) {
		categoryService.delete(categoryId);
	}
	@GetMapping("/category/get/{id}")
	public CategoryDto getCategory(@PathVariable("id") long categoryId) {
		return categoryService.find(categoryId);
	}
	@GetMapping("/categories")
	public List<CategoryDto> getCategories() {
        return categoryService.list();
    }
}
