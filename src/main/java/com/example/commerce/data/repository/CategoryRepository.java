package com.example.commerce.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.commerce.data.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
