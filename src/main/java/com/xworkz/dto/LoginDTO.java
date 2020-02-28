package com.xworkz.dto;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {
	
	private String email;
	private  String password;
	
	public LoginDTO() {
		System.out.println("Created\t"+this.getClass().getSimpleName());
	}

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

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}
	
}
