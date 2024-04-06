package com.shoppingapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
