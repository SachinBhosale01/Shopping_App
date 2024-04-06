package com.shoppingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.entities.User;
import com.shoppingapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// 3
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

}
