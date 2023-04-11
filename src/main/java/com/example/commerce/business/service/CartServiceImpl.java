package com.example.commerce.business.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerce.data.entity.Cart;
import com.example.commerce.data.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
	@Autowired
    private CartRepository cartRepository;

	@Override
	public Optional<Cart> findById(long id) {
		   return cartRepository.findById(id);
	}

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		cartRepository.delete(cart);
		
	}
	

    

}
