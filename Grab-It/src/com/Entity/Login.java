package com.Entity;

import org.hibernate.validator.constraints.NotBlank;

public class Login {

	@NotBlank(message="Email should not be blank")
	private String email;
	@NotBlank(message="password should not be blank")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
