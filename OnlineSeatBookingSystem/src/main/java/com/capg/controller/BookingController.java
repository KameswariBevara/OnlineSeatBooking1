package com.capg.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;
import com.capg.service.BookingService;

@RestController
@RequestMapping("/osb-bookingdetails")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping("/bookings")
	public String addBooking(@Valid @RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}

	@GetMapping("/bookings")
	public List<Booking> listAllbookings() {
		return bookingService.listAllbookings();
	}
	

	@GetMapping("/bookings/{startDate}/{endDate}")
	public List<Booking> listAllBookingsInDateRange(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
			throws BookingNotFoundException {
		return bookingService.listAllBookingsInDateRange(startDate, endDate);
	}

	@GetMapping("/bookings-byId/{bookingId}")
	public Booking getBookingbyId(@PathVariable int bookingId) throws BookingNotFoundException {
		return bookingService.getBookingbyId(bookingId);
	}

	@DeleteMapping("/bookings/{bookingId}")
	public Booking deleteBooking(@PathVariable int bookingId) throws BookingNotFoundException {
		return bookingService.deleteBooking(bookingId);
	}

}
