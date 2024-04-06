package com.shoppingapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	//5th && 3
	List<Order> findByUserId(Long userId);

	//6th
	List<Order> findByUserIdAndOrderId(Long userId, Long orderId);
}
