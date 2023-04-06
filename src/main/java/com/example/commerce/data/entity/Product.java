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
@Table(name="product")
public class Product {
	
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long productId;
	@Column(name = "category_name")
	private String productName;
	@Column(name = "sales_price")
	private double salesPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id",insertable = false, updatable = false)
    private Category category;
	
    public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

    
}
