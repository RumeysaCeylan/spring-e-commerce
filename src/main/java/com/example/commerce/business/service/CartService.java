package com.example.commerce.business.service;

import java.util.Optional;

import com.example.commerce.data.entity.Cart;

public interface CartService {
	 Optional<Cart> findById(long id);
	    Cart save(Cart cart);
	    void delete(Cart cart);
	   long getLatestCartId();
	   Cart getLatestCart();
	   

	
}
