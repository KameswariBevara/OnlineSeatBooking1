package com.capg.entity;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer; 

@Entity
public class Bookingdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingdetailsId;
	
	private String bookingStatus;
	
	private Long duration;
	

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
    
	@NotEmpty
	@Email
	private String uemailId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id", referencedColumnName = "aId")
	private Admin admin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
	private Booking booking;

	public Bookingdetails() {
		super();
	}

	public Bookingdetails(int bookingdetailsId, String bookingStatus, Long duration, LocalDate date, String uemailId,
			Admin admin, Booking booking) {
		super();
		this.bookingdetailsId = bookingdetailsId;
		this.bookingStatus = bookingStatus;
		this.duration = duration;
		this.date = date;
		this.uemailId = uemailId;
		this.admin = admin;
		this.booking = booking;
	}

	public int getBookingdetailsId() {
		return bookingdetailsId;
	}

	public void setBookingdetailsId(int bookingdetailsId) {
		this.bookingdetailsId = bookingdetailsId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUemailId() {
		return uemailId;
	}

	public void setUemailId(String uemailId) {
		this.uemailId = uemailId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Booking_details [bookingdetailsId=" + bookingdetailsId + ", bookingStatus=" + bookingStatus
				+ ", duration=" + duration + ", date=" + date + ", uemailId=" + uemailId + "]";
	}

	

	


}
