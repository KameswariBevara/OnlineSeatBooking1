package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Bookingdetails;
import com.capg.exception.BookingNotFoundException;
import com.capg.service.BookingdetailsService;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/osb-bookingdetails")
public class BookingdetailsController {

	@Autowired
	BookingdetailsService bookingDetailsService;

	@PostMapping("/bookingDetails")
	public Bookingdetails addBookingdetails(@RequestBody Bookingdetails bookingDetails) {
		return bookingDetailsService.addBookingdetails(bookingDetails);
	}

	@PutMapping("/bookingDetails")
	public Bookingdetails updateBookingDetails(@RequestBody Bookingdetails bookingDetails)
			throws BookingNotFoundException {
		return bookingDetailsService.updateBookingDetails(bookingDetails);
	}

	@GetMapping("/bookingdetails/{Id}")
	public List<Bookingdetails> getAllBookingdetailsByBookingId(@PathVariable("Id") int bookingId) {
		return bookingDetailsService.getAllBookingdetailsByBookingId(bookingId);
	}

}
