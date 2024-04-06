package com.shoppingapp.dto;

public class PostResponse {

	private Long orderId;
	private Long uderId;
	private int quantity;
	private double amount;
	private String coupon;

	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected PostResponse(Long orderId, Long uderId, int quantity, double amount, String coupon) {
		super();
		this.orderId = orderId;
		this.uderId = uderId;
		this.quantity = quantity;
		this.amount = amount;
		this.coupon = coupon;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUderId() {
		return uderId;
	}

	public void setUderId(Long uderId) {
		this.uderId = uderId;
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

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

}
