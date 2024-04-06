package com.shoppingapp.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shoppingapp.dto.PaymentResponse;
import com.shoppingapp.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// Payment for 4th request
	@PostMapping("/{userId}/{orderId}/pay")
	public ResponseEntity<?> payOrder(@PathVariable Long userId, @PathVariable Long orderId,
			@RequestParam double amount) {
		// Mocking payment API
		int randomStatusCode = getRandomStatusCode();
		String transactionId = "tran01010000" + new Random().nextInt(1000);

		if (randomStatusCode == 200) {
			paymentService.processPayment(userId, orderId, amount, transactionId, "successful");
			return ResponseEntity.ok().body(new PaymentResponse(userId, orderId, transactionId, "successful"));
		} else if (randomStatusCode == 400) {
			paymentService.processFailedPayment(userId, orderId, amount, transactionId, "failed",
					"Payment Failed as amount is invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PaymentResponse(userId, orderId,
					transactionId, "failed", "Payment Failed as amount is invalid"));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}

	// Mocking random status codes for payment API
	private int getRandomStatusCode() {
		Random random = new Random();
		return random.nextBoolean() ? 200 : 400;
	}
}
