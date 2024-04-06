package com.shoppingapp.dto;

import java.util.Date;

public class OrderDTO {

	private Long orderId;
	private double amount;
	private Date date;
	private String coupon;
	private String transactionId;
	private String status;
	private String description;

	protected OrderDTO(Long orderId, double amount, Date date, String coupon, String transactionId, String status,
			String description) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon = coupon;
		this.transactionId = transactionId;
		this.status = status;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected OrderDTO(Long orderId, double amount, Date date, String coupon, String transactionId, String status) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon = coupon;
		this.transactionId = transactionId;
		this.status = status;
	}

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
