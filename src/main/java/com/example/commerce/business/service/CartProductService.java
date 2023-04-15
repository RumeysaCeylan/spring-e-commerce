package com.example.commerce.business.service;

import java.util.List;
import java.util.Optional;

import com.example.commerce.data.entity.CartProduct;

public interface CartProductService {
	CartProduct save(CartProduct cartProduct);
    void delete(CartProduct cartProduct);
    List<CartProduct> findAllByCartId(long cartId);
    List<CartProduct> getDistinctCartProductsByCartId(long cartId);

    Optional<CartProduct> findById(long id);

}
