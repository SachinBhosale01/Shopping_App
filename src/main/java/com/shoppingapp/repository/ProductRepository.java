package com.shoppingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingapp.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	//3	
	 @Query("SELECT p FROM Product p WHERE p.availableQuantity > 0 ORDER BY p.id ASC")
	Optional<Product> findAvailableProduct();

}
