package com.example.commerce.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.commerce.data.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findByCategoryId(Long categoryId);

}
