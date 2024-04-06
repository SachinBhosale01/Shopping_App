package com.shoppingapp.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.entities.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    // Use this method for querying only by coupon code
    Optional<Coupon> findByCouponCode(String couponCode);

}
