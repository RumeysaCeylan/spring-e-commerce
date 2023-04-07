package com.example.commerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.commerce.data.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	 @Query("select p from Product p where p.category.categoryId = :category_id")
	 List<Product> findByCategoryId(@Param("category_id") long categoryId);

}
