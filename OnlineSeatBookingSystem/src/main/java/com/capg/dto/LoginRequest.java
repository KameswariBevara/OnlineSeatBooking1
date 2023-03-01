package com.capg.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

@Data

@Builder

public class LoginRequest implements Serializable {

	
	private static final long serialVersionUID = 1215396525450552776L;
	
	@NotNull(message = "Invalid email:Email is Null")
	private String email;
	
	@Pattern(regexp = "@ 2 / *",message = "valid")
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
