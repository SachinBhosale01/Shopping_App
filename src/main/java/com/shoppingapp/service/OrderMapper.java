package com.shoppingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.shoppingapp.dto.OrderDTO;
import com.shoppingapp.entities.Order;
import com.shoppingapp.entities.Payment;

public class OrderMapper {

	public static List<OrderDTO> mapToDTO(List<Order> orders) {
		return orders.stream().map(OrderMapper::mapToDTO).collect(Collectors.toList());
	}

	public static List<OrderDTO> mapToDTO2(List<Payment> orders) {
		return orders.stream().map(OrderMapper::mapToDTO2).collect(Collectors.toList());
	}

	public static OrderDTO mapToDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setAmount(order.getAmount());
		dto.setDate(order.getOrderDate());
		dto.setCoupon(order.getCoupon().getCouponCode());
		return dto;
	}

	public static OrderDTO mapToDTO2(Payment order) {
		OrderDTO dto = new OrderDTO();
		dto.setTransactionId(order.getTransactionId());
		dto.setStatus(order.getStatus());
		dto.setDescription(order.getDescription());
		return dto;
	}
}
