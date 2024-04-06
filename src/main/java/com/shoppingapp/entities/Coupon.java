package com.shoppingapp.entities;

import jakarta.persistence.*;

@Entity
public class Coupon {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long couponId;
    private String couponCode;
    private int discount;
	protected Coupon() {
		super();		
	}
	protected Coupon(Long couponId, String couponCode, int discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.discount = discount;
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
	
}
