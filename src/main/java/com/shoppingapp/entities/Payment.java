package com.shoppingapp.entities;

import jakarta.persistence.*;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private String transactionId;
	private String description;
	private String status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Payment() {
		super();
	}

	protected Payment(Long paymentId, Order order, Product product, String transactionId, String description,
			String status, User user) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.product = product;
		this.transactionId = transactionId;
		this.description = description;
		this.status = status;
		this.user = user;
	}

	public Payment(Long paymentId, Order order, Product product, String transactionId, String description,
			String status) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.product = product;
		this.transactionId = transactionId;
		this.description = description;
		this.status = status;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
