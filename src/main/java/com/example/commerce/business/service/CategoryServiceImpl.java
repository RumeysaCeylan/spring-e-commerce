package com.example.commerce.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.data.entity.Category;
import com.example.commerce.data.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
	
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void add(CategoryDto categoryDto) {
		Category category = toEntity(categoryDto);
		System.out.println(category.getCategoryId());
		categoryRepository.save(category);
		
	}

	@Override
	public void update(CategoryDto categoryDto) {
		Category category = toEntity(categoryDto);
		categoryRepository.save(category);
		
	}

	@Override
	public void delete(long categoryId) {
		
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDto find(long categoryId) {
		Optional<Category> optional = categoryRepository.findById(categoryId);
		if(optional.isPresent()) {
			
			return toDto(optional.get());
		}
		return null;
	}

	@Override
	public List<CategoryDto> list() {
		List<CategoryDto> categories = new ArrayList<>();
		for (Category category : categoryRepository.findAll()) {
			categories.add(toDto(category));			
		}
		System.out.println(categories.size()+" retrieved");
		return categories;
	}

	private CategoryDto toDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}
	
	private Category toEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryName(categoryDto.getCategoryName());
		return category;
	}

}
