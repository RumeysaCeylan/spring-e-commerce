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
    @Query(value="SELECT * FROM cart_product WHERE cart_id = :cart_id",nativeQuery = true)
	List<CartProduct> findAllByCartId(@Param("cart_id") long cartId);
    @Query(value="SELECT DISTINCT cp.cart_product_id, cp.product_id, cp.sales_quantity FROM cart_product cp WHERE cp.cart_id = :cart_id", nativeQuery = true)
	List<Object[]> getDistinctCartProductsByCartId(@Param("cart_id") long cartId);

}
