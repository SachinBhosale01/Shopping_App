package com.shoppingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.entities.Product;
import com.shoppingapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired(required = true)
	private ProductRepository productRepository;

	// 1
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// ppp
	public boolean checkProductAvailability(Long productId, int quantity) {
		Product product = productRepository.findById(productId).orElse(null);
		return product != null && product.getAvailableQuantity() >= quantity;
	}

	public double getProductPrice(Long productId) {
		Product product = productRepository.findById(productId).orElse(null);
		return product != null ? product.getPrice() : 0.0;
	}

}
