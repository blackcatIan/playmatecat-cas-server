package com.playmatecat.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message="用户名必填")
	private String username;
	
	@NotEmpty(message="密码必填")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
