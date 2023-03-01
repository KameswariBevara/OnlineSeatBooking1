package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.LoginRequest;
import com.capg.entity.Admin;
import com.capg.entity.Bookingdetails;
import com.capg.exception.UserNotFoundException;
import com.capg.service.AdminService;

@RestController
@RequestMapping("/osb-admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/admins")
	public String addAdmin(@RequestBody Admin admin) // add details of admin
	{
		return adminService.addAdmin(admin);
	}

	@PostMapping("/admins/login") // login with email and password
	public Admin loginAdmin(@RequestBody LoginRequest request) throws UserNotFoundException {
		return adminService.loginAdmin(request.getEmail(), request.getPassword());
	}

	@GetMapping("/admins/{aemailId}") // get details of admin by using email
	public Admin getAdminById(@PathVariable String aemailId) throws UserNotFoundException {
		return adminService.getAdminByEmailId(aemailId);
	}

	@PutMapping("/admins") // update the details of admin
	public Admin updateAdmin(@RequestBody Admin admin) throws UserNotFoundException {
		return adminService.updateAdmin(admin);
	}

	@DeleteMapping("/admins/{id}") // delete the admin details by using id
	public Admin deleteAdmin(@PathVariable int id) {
		return adminService.deleteAdmin(id);
	}

	@PutMapping("/approve-bookings/{bookingId}") // admin approves the booking
	public Bookingdetails approveBooking(int bookingId) throws UserNotFoundException {
		return adminService.approveBooking(bookingId);
	}

	@PutMapping("/reject-bookings/{bookingId}") // admin rejects the booking
	public Bookingdetails rejectBooking(int bookingId) throws UserNotFoundException {
		return adminService.rejectBooking(bookingId);
	}

	@PutMapping("/disallow-bookings/{bookingId}") // dis allowing booking
	public Bookingdetails disallowBooking(int bookingId) throws UserNotFoundException {
		return adminService.disallowBooking(bookingId);
	}

	@PutMapping("/approve-cancellation/{bookingId}") // approve cancellation
	public Bookingdetails approveCancellation(int bookingId) throws UserNotFoundException {
		return adminService.approveBooking(bookingId);
	}
}
