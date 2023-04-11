package com.example.commerce.business.dto;



import java.util.ArrayList;
import java.util.List;

import com.example.commerce.data.entity.Cart.Status;

public class CartDto {
	private long cartId;
	private String customerName;
	private String cardNumber;
	private Status status;
	private List<CartProductDto> cartProducts = new ArrayList<>();

	public CartDto() {
		
	}

	public CartDto(long cartId, String customerName, String cardNumber, Status status) {
		
		this.cartId = cartId;
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.status = status;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<CartProductDto> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProductDto> cartProducts) {
		this.cartProducts = cartProducts;
	}


}
