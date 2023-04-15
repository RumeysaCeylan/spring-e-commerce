package com.example.commerce.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.commerce.data.entity.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{
    @Query(value = "SELECT * FROM cart ORDER BY cart_id DESC LIMIT 1", nativeQuery = true)
	Optional<Cart> findTopByOrderByIdDesc();

}
