package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.User;
import com.capg.exception.UserNotFoundException;
import com.capg.service.UserService;

@RestController
@RequestMapping("/osb-user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public String userService(@Valid @RequestBody User user) {
	
		return userService.addUser(user);
	}

	@GetMapping("/users")
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}

	@GetMapping("/loginUser/{emailId}/{password}")
	public User loginUser(@PathVariable String emailId, @PathVariable String password) throws UserNotFoundException {
		return userService.loginUser(emailId, password);
	}

	@GetMapping("/findByUserId/{uId}")
	public User findByUserId(@PathVariable int uId) throws UserNotFoundException {
		return userService.findByUserId(uId);
	}

	@GetMapping("/isAdmin/{emailId}")
	public boolean isAdmin(@PathVariable String emailId) {
		return userService.isAdmin(emailId);
	}

//	@GetMapping("/validateSecurityAnswer/{emailId}/{securityAnswer}")
//	public boolean validateSecurityAnswer(@PathVariable String emailId, @PathVariable String securityAnswer) {
//		return userService.validateSecurityAnswer(emailId, securityAnswer);
//	}

//	@PutMapping("/resetPassword/{emailId}/{password}")
//	public void resetPassword(@PathVariable String emailId, @PathVariable String password) {
//		userService.resetPassword(emailId, password);
//	}

	@DeleteMapping("/deleteByUserEmailId/{emailId}")
	public User deleteByUserEmailId(@PathVariable String emailId) throws UserNotFoundException {
		return userService.deleteByUserEmailId(emailId);
	}

	@PostMapping("/updateUser")
	public void save(@RequestBody User users) {
		userService.save(users);
	}

//	@PutMapping("/swapBookings/{bookingId1}/{bookingId2}")
//	public boolean swapBookings(int bookingId1, int bookingId2) throws BookingNotFoundException {
//		return userService.swapBookings(bookingId1, bookingId2);
//	}
}
