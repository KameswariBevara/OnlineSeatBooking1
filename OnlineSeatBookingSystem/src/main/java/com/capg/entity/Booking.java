package com.capg.entity;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

import com.capg.validation.ValidBookingDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Booking { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;

	@NotEmpty(message = "Seat number is mandatory")
	private String seatNumber;
	
//	@JsonDeserialize(using = LocalDateDeserializer.class)
//	@JsonSerialize(using = LocalDateSerializer.class)
	
    
//	@Temporal(TemporalType.DATE)
//	private Date date=new Date(System.currentTimeMillis())
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	
	@Future
	@ApiModelProperty(notes="Booking date should be in the future")  
	private Date bookingDate;
	
	
	@NotEmpty(message="Booking address is mandatory")
    private String bookingAddress;
	
	@Min(value = 1,message = "Duration should not be more than 1 day")

	private int duration;
	
//	@NotBlank(message = "Email is mandatory")
	
//	@NotEmpty(message="Email is mandatory")
//    @Email
//	private String uemail_Id;
	@Valid
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "uId")
    private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Booking() {
		super();
	}

//	public Booking(int bookingId, String seatNumber, Date bookingDate, String bookingAddress, int duration,
//			User user) {
//		super();
//		this.bookingId = bookingId;
//		this.seatNumber = seatNumber;
//		this.bookingDate = bookingDate;
//		this.bookingAddress = bookingAddress;
//		this.duration = duration;
//		this.user = user;
//
//	}

	public int getBookingId() {
		return bookingId;
	}

	
//	public Booking(int bookingId, @NotEmpty(message = "Seat number is mandatory") String seatNumber,
//		@Future Date bookingDate, @NotEmpty(message = "Booking address is mandatory") String bookingAddress,
//		@Min(value = 1, message = "Duration should not be more than 1 day") int duration, User user) {
//	super();
//	this.bookingId = bookingId;
//	this.seatNumber = seatNumber;
//	this.bookingDate = bookingDate;
//	this.bookingAddress = bookingAddress;
//	this.duration = duration;
//	this.user = user;
//}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public Booking(int bookingId, @NotEmpty(message = "Seat number is mandatory") String seatNumber,
			@Future Date bookingDate, @NotEmpty(message = "Booking address is mandatory") String bookingAddress,
			@Min(value = 1, message = "Duration should not be more than 1 day") int duration, User user) {
		super();
		this.bookingId = bookingId;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
		this.bookingAddress = bookingAddress;
		this.duration = duration;
		this.user = user;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

//	public Date getBookingDate() {
//		return bookingDate;
//	}
//
//	public void setBookingDate(Date bookingDate) {
//		this.bookingDate = bookingDate;
//	}

	public String getBookingAddress() {
		return bookingAddress;
	}

	public void setBookingAddress(String bookingAddress) {
		this.bookingAddress = bookingAddress;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", seatNumber=" + seatNumber + ", bookingDate=" + bookingDate
				+ ", bookingAddress=" + bookingAddress + ", duration=" + duration + ", user=" + user + "]";
	}

}
