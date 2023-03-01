package com.capg.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;

public interface BookingService {

	public String addBooking(Booking booking);

	public List<Booking> listAllbookings() throws BookingNotFoundException;

	public List<Booking> listAllBookingsInDateRange(java.util.Date startDate, java.util.Date endDate)
			throws BookingNotFoundException;

	public Booking getBookingbyId(int bookingId) throws BookingNotFoundException;

	public Booking deleteBooking(int bookingId) throws BookingNotFoundException;

	List<Booking> listAllBookingsInDateRange(Date startDate, Date endDate) throws BookingNotFoundException;


}