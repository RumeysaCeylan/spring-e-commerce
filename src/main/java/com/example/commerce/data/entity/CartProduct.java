package com.example.commerce.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_product")
public class CartProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_product_id")
	private long cartProductId;
	
	@Column(name = "sales_quantity")
	private long salesQuantity;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id",insertable=true, updatable=true)
	private Cart cart;
	
	
	@Column(name = "product_id")
	private long productId;
	
	public CartProduct() {

	}
	
	public CartProduct(long cartProductId, long salesQuantity, Cart cart, long productId) {
		
		this.cartProductId = cartProductId;
		this.salesQuantity = salesQuantity;
		this.cart = cart;
		this.productId = productId;
	}


	public long getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}
	
	public long getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(long salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

}
