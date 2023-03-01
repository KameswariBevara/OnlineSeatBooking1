package com.capg.service;

import java.util.List;

import com.capg.entity.User;
import com.capg.exception.SeatNotFoundException;
import com.capg.exception.UserNotFoundException;

public interface UserService {

	public String addUser(User user);

	public List<User> listAllUsers() throws SeatNotFoundException;

	public User loginUser(String emailId, String password) throws UserNotFoundException;

	public User findByUserEmailId(String emailId) throws UserNotFoundException;

	public boolean isAdmin(String emailId);

	public boolean validateSecurityAnswer(String emailId, String securityAnswer);

	public void resetPassword(String emailId, String password);

	public User deleteByUserEmailId(String emailId) throws UserNotFoundException;

	public void updateUserPasswordByEmailId(String emailId, String password) throws UserNotFoundException;

	public User findByUserId(int uId) throws UserNotFoundException;

	public void save(User users);

	// public boolean swapBookings(int bookingId1, int bookingId2) throws
	// BookingNotFoundException;
}
