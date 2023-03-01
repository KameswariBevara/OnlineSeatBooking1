package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aId;// primary key

	@NotEmpty
	@Size(min = 4, message = "adminName must be min of 4 characters !!")
	private String adminName;

	@NotEmpty
	@Email(message = "emailId address is not valid !!")
	private String emailId;

	private String username;

	@NotEmpty
	private String password;

	private String role;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin(Integer aId, String adminName, String emailId, String username, String password, String role) {
		super();
		this.aId = aId;
		this.adminName = adminName;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

}
