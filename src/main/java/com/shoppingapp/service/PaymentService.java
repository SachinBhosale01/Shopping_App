package com.shoppingapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.entities.*;

import com.shoppingapp.repository.*;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;



	// 4th
	public void processPayment(Long userId, Long orderId, double amount, String transactionId, String status) {
		Payment payment = new Payment();
		payment.setTransactionId(transactionId); // Generate a unique transaction ID
		payment.setStatus("Success"); // Set payment status

		Date date = new Date();
		Order order = new Order();
		order.setOrderId(orderId);
		order.setAmount(amount);
		order.setOrderDate(date);

		User user = new User();
		user.setId(userId);

		// Save the payment details to the database
		paymentRepository.save(payment);
		orderRepository.save(order);
		userRepository.save(user);
	}

	public void processFailedPayment(Long userId, Long orderId, double amount, String transactionId, String status,
			String description) {
		Payment payment = new Payment();
		payment.setTransactionId(transactionId); // Generate a unique transaction ID
		payment.setStatus("Success"); // Set payment status

		Date date = new Date();
		Order order = new Order();
		order.setOrderId(orderId);
		order.setAmount(amount);
		order.setOrderDate(date);

		User user = new User();
		user.setId(userId);

		// Save the payment details to the database
		paymentRepository.save(payment);
		orderRepository.save(order);
		userRepository.save(user);
	}
	
	
	//For NewOrder
	public boolean makePayment( Long productId, int quantity, double totalAmount) {

		// Assuming payment gateway integration or any other payment processing logic


		// For the sake of this example, let's assume the payment is successful.
		Payment payment = new Payment();
		// Generate a unique transaction ID
		String transactionId = "tran01010000" + new Random().nextInt(1000);

		payment.setTransactionId(transactionId); // Generate a unique transaction ID
		payment.setStatus("Success"); // Set payment status
		payment.setDescription("Payment done");
		payment.setProduct(new Product(productId));

		Date date = new Date();
		Order order = new Order();
		order.setQuantity(quantity);
		order.setAmount(totalAmount);
		order.setOrderDate(date);


		// Save the payment details to the database
		paymentRepository.save(payment);
		orderRepository.save(order);
		

		return true; // Return true indicating payment success
	}

}