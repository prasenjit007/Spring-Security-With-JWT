package com.security.jwt.moel;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public AuthenticationRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
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
