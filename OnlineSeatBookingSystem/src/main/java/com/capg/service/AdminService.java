package com.capg.service;

import com.capg.entity.Admin;
import com.capg.entity.Bookingdetails;
import com.capg.exception.UserNotFoundException;

public interface AdminService {

	public String addAdmin(Admin admin);

	public Admin loginAdmin(String emailId, String password) throws UserNotFoundException;

	public Admin getAdminByEmailId(String aemailId) throws UserNotFoundException;

	public Admin updateAdmin(Admin adminDetails) throws UserNotFoundException;

	public Admin deleteAdmin(int adminId) throws UserNotFoundException;

	public boolean grantAdminRights(String emailid) throws UserNotFoundException;

	public Bookingdetails approveBooking(int bookingId) throws UserNotFoundException;

	public Bookingdetails rejectBooking(int bookingId) throws UserNotFoundException;

	public Bookingdetails disallowBooking(int bookingId) throws UserNotFoundException;

	public Bookingdetails approveCancellation(int bookingId) throws UserNotFoundException;

}
