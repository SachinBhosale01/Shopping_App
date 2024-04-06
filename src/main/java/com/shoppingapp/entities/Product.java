package com.shoppingapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private int ordered;
	private int availableQuantity;;
	private double price;

	public Product() {
		super();
	}

	protected Product(Long productId, int availableQuantity, double price, int ordered) {
		super();
		this.productId = productId;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.ordered = ordered;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrdered() {
		return ordered;
	}

	public void setOrdered(int ordered) {
		this.ordered = ordered;
	}

	// place order
	public Product(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", availableQuantity=" + availableQuantity + ", ordered=" + ordered
				+ ", price=" + price + "]";
	}

}
