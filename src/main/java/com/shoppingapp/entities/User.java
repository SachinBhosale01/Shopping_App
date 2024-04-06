package com.shoppingapp.entities;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;

	private String username;

	public User() {
		super();
	}

	protected User(Long userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// first place order
	public User(Long userId) {
		this.userId = userId;
	}

}