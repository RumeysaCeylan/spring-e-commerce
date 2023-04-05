package com.example.commerce.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.commerce.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
