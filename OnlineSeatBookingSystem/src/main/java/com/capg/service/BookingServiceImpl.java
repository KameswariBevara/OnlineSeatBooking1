package com.capg.service;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingRepository;

@Service("BookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	static Date date = new Date(System.currentTimeMillis());
	@SuppressWarnings("deprecation")
	@Override
	public String addBooking(Booking booking) {
		bookingRepository.saveAndFlush(booking);
		String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);  
		Matcher matcher = pattern.matcher(booking.getUser().getEmailId());
		if(booking.getBookingDate().getMonth()!=date.getMonth())
		{
			
			return "Request failed for booking sent";
		}
//		else if(matcher.matches()==false)
//		{
//			return "InValid email address";
//		}
		else {
		return "Request for booking sent";
		}
	}

	@Override
	public List<Booking> listAllbookings() throws BookingNotFoundException {
		return bookingRepository.findAll();
	}

//	@Override
//	public List<Booking> listAllBookingsInDateRange(LocalDate startDate, LocalDate endDate)
//			throws BookingNotFoundException {
//		List<Booking> ans = new ArrayList<Booking>();
//		try {
//			for (Booking i : bookingRepository.findAll()) {
//				if (i.getBookingDate().isAfter(startDate) && i.getBookingDate().isBefore(endDate)) {
//					ans.add(i);
//				}
//			}
//		} catch (Exception e) {
//			throw new BookingNotFoundException("Booking not found");
//		}
//		return ans;
//	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public Booking getBookingbyId(int bookingId) throws BookingNotFoundException {
		Booking bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Booking not found!");
		}
		return bean;
	}

	@Override
	public Booking deleteBooking(int bookingId) throws BookingNotFoundException {
		Booking bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Booking not found!");
		}
		bookingRepository.deleteById(bookingId);
		return bean;
	}
	
	

	@Override
	public List<Booking> listAllBookingsInDateRange(Date startDate, Date endDate)
			throws BookingNotFoundException {
		// TODO Auto-generated method stub
		List<Booking> ans = new ArrayList<Booking>();
		try {
			for (Booking i : bookingRepository.findAll()) {
				if (i.getBookingDate().after(startDate) && i.getBookingDate().before(endDate)) {
					ans.add(i);
				}
			}
		} catch (Exception e) {
			throw new BookingNotFoundException("Booking not found");
		}
		return ans;
	}

	@Override
	public List<Booking> listAllBookingsInDateRange(java.util.Date startDate, java.util.Date endDate)
			throws BookingNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
