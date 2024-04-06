package com.shoppingapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private Date orderDate;
	private int quantity;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "coupon_id")
	private Coupon coupon;

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	// Constructors
	public Order() {
	}

	protected Order(long orderId, User user, Date orderDate, int quantity, double amount, Coupon coupon) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.amount = amount;
		this.coupon = coupon;
	}

	protected Order(long orderId, User user, Product product, Date orderDate, int quantity, double amount,
			Coupon coupon, Payment payment) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.product = product;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.amount = amount;
		this.coupon = coupon;
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date date) {
		this.orderDate = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
