package com.shoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.entities.Coupon;
import com.shoppingapp.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	CouponRepository couponRepository;

	// 2
	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}
}