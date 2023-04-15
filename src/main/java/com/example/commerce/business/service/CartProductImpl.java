package com.example.commerce.business.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public List<CartProduct> getDistinctCartProductsByCartId(long cartId) {
		List<Object[]> cartProductsData = cartProductRepository.getDistinctCartProductsByCartId(cartId);
	    
	    List<CartProduct> cartProducts = cartProductsData.stream().map(data -> {
	        CartProduct cartProduct = new CartProduct();
	        cartProduct.setCartProductId(((Long) data[0]).longValue());
	        cartProduct.setProductId(((Long) data[1]).longValue());
	        cartProduct.setSalesQuantity((Long) data[2]);
	        return cartProduct;
	    }).collect(Collectors.toList());
	    return cartProducts;
	}

	@Override
	public Optional<CartProduct> findById(long id) {
		   return cartProductRepository.findById(id);

	}
	
	
  
}
