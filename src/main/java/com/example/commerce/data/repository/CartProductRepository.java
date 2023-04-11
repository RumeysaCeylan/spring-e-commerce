package com.example.commerce.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.commerce.data.entity.Cart;
import com.example.commerce.data.entity.CartProduct;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long>{
    @Query("SELECT cp FROM CartProduct cp WHERE cp.cart.cartId = :cartId")
	List<CartProduct> findAllByCartId(@Param("cartId") long cartId);

}
