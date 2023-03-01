package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Seat;
import com.capg.exception.SeatNotFoundException;
import com.capg.service.SeatService;

@RestController
@RequestMapping("/osb-seat")
public class SeatController {

	@Autowired
	SeatService seatService;

	@PostMapping("/seats")
	public String addSeats(@RequestBody Seat seat) {
		return seatService.addSeats(seat);
	}

	@GetMapping("/seats")
	public List<Seat> listAllSeats() {
		return seatService.listAllSeats();
	}

	@GetMapping("/seats/{seatNumber}")
	public Seat findBySeatNumber(@PathVariable String seatNumber) throws SeatNotFoundException {
		return seatService.findBySeatNumber(seatNumber);
	}

	@GetMapping("/seats-byFloor/{seatFloor}")
	public Seat findBySeatFloor(@PathVariable int seatFloor) {
		return seatService.findBySeatFloor(seatFloor);
	}

	@GetMapping("/seats-byLocation/{seatLocation}")
	public List<Seat> findBySeatLocation(@PathVariable String seatLocation) {
		return seatService.findBySeatLocation(seatLocation);
	}

	@PutMapping("/seats")
	public Seat updateSeats(@RequestBody Seat seat) throws SeatNotFoundException {
		return seatService.updateSeats(seat);
	}

	@DeleteMapping("/seats/{seatNumber}")
	public void deleteSeats(@PathVariable String seatNumber) {
		seatService.deleteSeats(seatNumber);
	}

}
