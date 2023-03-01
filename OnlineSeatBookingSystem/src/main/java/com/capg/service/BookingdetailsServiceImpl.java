package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Bookingdetails;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingdetailsRepository;

@Service("BookingdetailsService")
public class BookingdetailsServiceImpl implements BookingdetailsService {

	@Autowired
	BookingdetailsRepository bookingDetailsRepository;

	@Override
	public Bookingdetails addBookingdetails(Bookingdetails bookingDetails) {
		bookingDetailsRepository.saveAndFlush(bookingDetails);
		return bookingDetails;
	}

	@Override
	public Bookingdetails updateBookingDetails(Bookingdetails bookingDetails) throws BookingNotFoundException {
		Bookingdetails bean = null;
		try {
			bean = bookingDetailsRepository.findById(bookingDetails.getBookingdetailsId()).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Booking details details not found!");
		}
		bookingDetailsRepository.saveAndFlush(bookingDetails);
		return bean;
	}

	@Override
	public List<Bookingdetails> getAllBookingdetailsByBookingId(int bookingId) {
		return bookingDetailsRepository.findAll();
	}

}
