package com.shoppingapp.dto;

import java.util.Date;

public class OrderResponse {

	private Long orderId;
	private Double amount;
	private Date date;
	private String coupon;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	protected OrderResponse(Long orderId, Double amount, Date date, String coupon) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.date = date;
		this.coupon = coupon;
	}

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
