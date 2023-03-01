package com.capg.service;

import java.util.List;

import com.capg.entity.Bookingdetails;
import com.capg.exception.BookingNotFoundException;

public interface BookingdetailsService {

	public Bookingdetails addBookingdetails(Bookingdetails bookingDetails);

	public Bookingdetails updateBookingDetails(Bookingdetails bookingDetails) throws BookingNotFoundException;

	public List<Bookingdetails> getAllBookingdetailsByBookingId(int bookingId);

}
