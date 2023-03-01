package com.capg.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;

	@NotEmpty(message="Email is mandatory")
    @Email(message="Mail id should be in valid format")
	private String emailId;

	private String password;

	private String securityAnswer;

	private String role;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="user", orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_Id", referencedColumnName = "bookingId")
	private Booking bookings;  
	
	
	public Booking getBookings() {
		return bookings;
	}


	public void setBookings(Booking bookings) {
		this.bookings = bookings;
	}


	public User() {
		super();
	}


//	public User(Integer uId, @NotEmpty @Email String emailId, String password, String securityAnswer, String role,
//			Booking bookings) {
//		super();
//		this.uId = uId;
//		this.emailId = emailId;
//		this.password = password;
//		this.securityAnswer = securityAnswer;
//		this.role = role;
//		this.bookings = bookings;
//	}

	public Integer getuId() {
		return uId;
	}

	public User(Integer uId, @NotEmpty @Email String emailId, String password, String securityAnswer, String role,
		Booking bookings) {
	super();
	this.uId = uId;
	this.emailId = emailId;
	this.password = password;
	this.securityAnswer = securityAnswer;
	this.role = role;
	this.bookings = bookings;
}


	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", emailId=" + emailId + ", password=" + password + ", securityAnswer="
				+ securityAnswer + "]";
	}

}
