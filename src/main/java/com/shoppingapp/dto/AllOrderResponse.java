package com.shoppingapp.dto;

import java.util.Date;

public class AllOrderResponse {
	private Long userId;
	private String username;
	
	private Long productId;
	private int ordered;
	private int availableQuantity;;
	private double price;
	
	
	private Long couponId;
	private String couponCode;
	private int discount;
	    
	private long orderId;
    private Date orderDate;
    private int quantity;
    private double amount;
    
    private Long paymentId;
    private String transactionId;
	private String description;
	private String status;
	public AllOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllOrderResponse(Long userId, String username, Long productId, int ordered, int availableQuantity,
			double price, Long couponId, String couponCode, int discount, long orderId, Date orderDate, int quantity,
			double amount, Long paymentId, String transactionId, String description, String status) {
		super();
		this.userId = userId;
		this.username = username;
		this.productId = productId;
		this.ordered = ordered;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discount = discount;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.amount = amount;
		this.paymentId = paymentId;
		this.transactionId = transactionId;
		this.description = description;
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getOrdered() {
		return ordered;
	}
	public void setOrdered(int ordered) {
		this.ordered = ordered;
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
	public Long getCouponId() {
		return couponId;
	}
	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

}
