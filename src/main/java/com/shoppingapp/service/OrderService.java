package com.shoppingapp.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shoppingapp.dto.*;
import com.shoppingapp.entities.*;
import com.shoppingapp.repository.*;

@Service
public class OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderRepository orderRepository;

	// Place order for 3rd request
	public ResponseEntity<?> placeOrder(Long userId, int qty, String couponCode) {
		// Retrieve user and product
		Optional<User> optionalUser = userRepository.findById(userId);

		if (!optionalUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
		if (qty > 100) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid quantity");
		}
		PostResponse postResponse = new PostResponse();

		List<Order> orderlist = orderRepository.findByUserId(userId);
		for (Order order : orderlist) {
			postResponse.setOrderId(order.getOrderId());
			postResponse.setUderId(order.getUser().getId());
			postResponse.setQuantity(order.getQuantity());
			postResponse.setAmount(order.getAmount());
			postResponse.setCoupon(order.getCoupon().getCouponCode());
			// break;
		}
		String coupon = postResponse.getCoupon();

		if (coupon.equals("OFF5") || coupon.equals("OFF10")) {
			// Coupon is valid
			saveAll(orderlist);
			return ResponseEntity.ok(postResponse);
		} else {
			// Coupon is not valid
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid coupon");
		}

	}

	private void saveAll(List<Order> orderlist) {
		Order order1 = new Order();
		for (Order orders : orderlist) {
			order1.setOrderId(orders.getOrderId());
			order1.setUser(orders.getUser());
			order1.setProduct(orders.getProduct());
			order1.setQuantity(orders.getQuantity());
			order1.setAmount(orders.getAmount());
			order1.setCoupon(orders.getCoupon());
			order1.setPayment(orders.getPayment());
			orderRepository.save(order1);
			// break;
		}

	}

	// Get user orders for 5th request
	public List<OrderResponse> getUserOrders(Long userId) {
		List<OrderResponse> orderList = new ArrayList<>();
		// Assuming you have a method in your repository to fetch user orders by user ID
		List<Order> orders = orderRepository.findByUserId(userId);
		for (Order order : orders) {
			OrderResponse orderRes = new OrderResponse();
			orderRes.setOrderId(order.getOrderId());
			orderRes.setAmount(order.getAmount());
			orderRes.setDate(order.getOrderDate());
			orderRes.setCoupon(order.getCoupon().getCouponCode());
			orderList.add(orderRes);
		}
		return orderList;
	}

	//Get order details for 6th requset
	public List<List<OrderDTO>> getOrderDetails(Long userId, Long orderId) {
		List<Order> orders = orderRepository.findByUserIdAndOrderId(userId, orderId);
		return orders.stream().map(this::formatOrder).collect(Collectors.toList());
	}

	private List<OrderDTO> formatOrder(Order order) {

		List<OrderDTO> orderDTO = new ArrayList<>();
		OrderDTO orderdto = new OrderDTO();
		orderdto.setOrderId(order.getOrderId());
		orderdto.setAmount(order.getAmount());
		orderdto.setDate(order.getOrderDate());
		orderdto.setCoupon(order.getCoupon().getCouponCode());
		orderdto.setTransactionId(order.getPayment().getTransactionId());
		orderdto.setStatus(order.getPayment().getStatus());
		orderdto.setDescription(order.getPayment().getDescription());

		orderDTO.add(orderdto);

		return orderDTO;
	}

	// Place new order
	public String placeNewOrder(Long productId, int quantity) {
		// Check if product is available in desired quantity
		boolean isAvailable = productService.checkProductAvailability(productId, quantity);
		if (!isAvailable) {
			return "Product is not available in the desired quantity";
		}

		Optional<Product> product = productRepository.findById(productId);

		Product product2 = product.get();
		double price = product2.getPrice();
		double amount = price * quantity;

		// apply coupon
		double discount = 0.0;
		if (amount >= 2000.00) {
			discount = 10.0;
		} else {
			discount = 5.0;
		}

		// Calculate total amount after discount
		double totalAmount = productService.getProductPrice(productId) * quantity * (1 - discount);

		// Make payment for the order
		boolean paymentStatus = paymentService.makePayment(productId, quantity, totalAmount);
		if (!paymentStatus) {
			return "Payment failed";
		}

		// Save order details
		Order order = new Order();
		order.setProduct(new Product(productId)); // Assuming Product constructor takes productId as argument
		order.setQuantity(quantity);
		order.setAmount(totalAmount);
		orderRepository.save(order);

		return "Order placed successfully";
	}

	// For View
	public List<AllOrderResponse> viewOrderStatus(Long userId) {

		List<AllOrderResponse> AllList = new ArrayList<>();
		// List<Order> order= orderRepository.findAll();
		List<Order> order = orderRepository.findByUserId(userId);

		for (Order or : order) {
			AllOrderResponse allRes = new AllOrderResponse();
			allRes.setOrderId(or.getOrderId());
			allRes.setOrderDate(or.getOrderDate());
			allRes.setQuantity(or.getQuantity());
			allRes.setAmount(or.getAmount());

			allRes.setPaymentId(or.getPayment().getPaymentId());
			allRes.setTransactionId(or.getPayment().getTransactionId());
			allRes.setDescription(or.getPayment().getDescription());
			allRes.setStatus(or.getPayment().getStatus());

			allRes.setUserId(or.getUser().getId());
			allRes.setUsername(or.getUser().getUsername());

			allRes.setProductId(or.getProduct().getProductId());
			allRes.setOrdered(or.getProduct().getOrdered());
			allRes.setAmount(or.getProduct().getAvailableQuantity());
			allRes.setPrice(or.getProduct().getPrice());

			allRes.setCouponId(or.getCoupon().getCouponId());
			allRes.setCouponCode(or.getCoupon().getCouponCode());
			allRes.setDiscount(or.getCoupon().getDiscount());

			AllList.add(allRes);

		}

		return AllList;
	}
}
