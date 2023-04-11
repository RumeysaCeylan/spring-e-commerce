package com.example.commerce.data.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	   public enum Status {
	        NEW,COMPLETED

	    }
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long cartId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "card_number")
	private String cardNumber;
	@Enumerated((EnumType.STRING))
	@Column(name = "cart_status")
	private Status status;
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CartProduct> cartProducts = new ArrayList<>();
	
	 public Cart() {
	
	    }
	 
	 

	public Cart(long cartId, String customerName, String cardNumber, List<CartProduct> cartProducts, Status status) {//
		this.cartId = cartId;
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.status = status;
		this.cartProducts = cartProducts;
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



	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}



	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}
