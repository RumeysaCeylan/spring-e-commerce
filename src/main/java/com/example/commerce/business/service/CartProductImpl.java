package com.example.commerce.business.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerce.data.entity.CartProduct;
import com.example.commerce.data.repository.CartProductRepository;


@Service
public class CartProductImpl implements CartProductService{
    @Autowired
    private CartProductRepository cartProductRepository;

	@Override
	public CartProduct save(CartProduct cartProduct) {
		 return cartProductRepository.save(cartProduct);
	}

	@Override
	public void delete(CartProduct cartProduct) {
		 cartProductRepository.delete(cartProduct);
		
	}

	@Override
	public List<CartProduct> findAllByCartId(long cartId) {
        return cartProductRepository.findAllByCartId(cartId);

	}

	@Override
	public Optional<CartProduct> findById(long id) {
		   return cartProductRepository.findById(id);

	}
	
	
  
}
