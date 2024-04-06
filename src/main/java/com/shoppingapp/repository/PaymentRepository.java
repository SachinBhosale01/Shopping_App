package com.shoppingapp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.entities.Payment;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, Long>{

	List<Payment> findByUserId(Long userId);
}
