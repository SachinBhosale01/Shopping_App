package com.shoppingapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.shoppingapp.dto.OrderDTO;
import com.shoppingapp.dto.OrderResponse;
import com.shoppingapp.service.*;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	// @GetMapping("/home")
	public String hone() {
		return "home page";
	}

	// Place order  for post request 3rd
	@PostMapping("/{userId}/order")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId, @RequestParam int qty, @RequestParam(required = false) String coupon) {
		// Proceed with placing the order
		ResponseEntity<?> response = orderService.placeOrder(userId, qty, coupon);
		return response;
	}
	
	// Get all orders of a user for 5th request
	@GetMapping("/{userId}/orders")
	public List<OrderResponse> getUserOrders(@PathVariable Long userId) {
		return orderService.getUserOrders(userId);
	}

	//Get order details for 6th request
	@GetMapping("/{userId}/orders/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
		// List<OrderDTO> orders = orderService.getOrderDetails(userId, orderId);
		List<List<OrderDTO>> orders = orderService.getOrderDetails(userId, orderId);
		if (orders.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(orders);
	}

}
