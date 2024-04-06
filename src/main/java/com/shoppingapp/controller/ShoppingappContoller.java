package com.shoppingapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.entities.Coupon;
import com.shoppingapp.entities.Product;
import com.shoppingapp.service.CouponService;

import com.shoppingapp.service.OrderService;
import com.shoppingapp.service.ProductService;

@RestController
public class ShoppingappContoller {

	@Autowired
	ProductService productService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private OrderService orderService;

	// Get all products for 1st request
	@GetMapping(value = "/inventory")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> productList = productService.getAllProducts();

		return ResponseEntity.ok(productList);
	}

	//// Fetch all coupons for 2nd request
	@GetMapping("/fetchCoupons")
	public ResponseEntity<?> fetchCoupons() {
		List<Coupon> couponList = couponService.getAllCoupons();
		if (couponList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No coupons found");
		}
		Map<String, Integer> couponMap = new HashMap<>();
		for (Coupon coupon : couponList) {
			couponMap.put(coupon.getCouponCode(), coupon.getDiscount());
		}
		return ResponseEntity.ok(couponMap);
	}

	// new order place here
	// POST {{url}}/{productId}/placeNewOrder?quantity=10
	@PostMapping("/{productId}/placeNewOrder")
	public ResponseEntity<String> placeNewOrder(@PathVariable Long productId, @RequestParam int quantity) {
		// Place order logic
		String result = orderService.placeNewOrder(productId, quantity);
		return ResponseEntity.ok(result);
	}

	// view all details by id
	@GetMapping("/{userId}/viewOrderStatus")
	public ResponseEntity<?> viewOrderStatus(@PathVariable Long userId) {
		return ResponseEntity.ok(orderService.viewOrderStatus(userId));
	}
}
