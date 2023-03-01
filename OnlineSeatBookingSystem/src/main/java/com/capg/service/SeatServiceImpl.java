package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Seat;
import com.capg.exception.SeatNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.SeatRepository;

@Service("SeatService")
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepository;

	@Override
	public String addSeats(Seat seat) {
		seatRepository.saveAndFlush(seat);
		return "Seat details added successfully";
	}

	@Override
	public List<Seat> listAllSeats() throws SeatNotFoundException {
		return seatRepository.findAll();
	}

	@Override
	public Seat findBySeatNumber(String seatNumber) throws SeatNotFoundException {
		Seat bean = new Seat();
		try {
			for (Seat i : seatRepository.findAll()) {
				if (i.getSeatNumber().equals(seatNumber)) {
					bean = i;
				}
			}
		} catch (Exception e) {
			throw new SeatNotFoundException("Booking details not found");
		}
		return bean;
	}

	@Override
	public Seat updateSeats(Seat seat) throws SeatNotFoundException {
		Seat bean = null;
		try {
			bean = seatRepository.findById(seat.getSeatId()).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Seat not found!");
		}
		seatRepository.saveAndFlush(seat);
		return bean;
	}

	@Override
	public Seat deleteSeats(String seatNumber) throws SeatNotFoundException {
		Seat bean = new Seat();
		try {
			for (Seat i : seatRepository.findAll()) {
				if (i.getSeatNumber().equals(seatNumber)) {
					bean = i;
				}
			}
		} catch (Exception e) {
			throw new SeatNotFoundException("Seat not found");
		}
		seatRepository.deleteById(bean.getSeatId());
		return bean;
	}

	@Override
	public Seat findBySeatFloor(int seatFloor) throws SeatNotFoundException {
		Seat bean = new Seat();
		try {
			for (Seat i : seatRepository.findAll()) {
				if (i.getSeatFloor() == seatFloor) {
					bean = i;
				}
			}
		} catch (Exception e) {
			throw new SeatNotFoundException("Seat not found");
		}
		return bean;
	}

	@Override
	public List<Seat> findBySeatLocation(String seatLocation) throws SeatNotFoundException {
		List<Seat> ans = new ArrayList<>();
		try {
			for (Seat i : seatRepository.findAll()) {
				if (i.getSeatLocation().equals(seatLocation)) {
					ans.add(i);
				}
			}
		} catch (Exception e) {
			throw new SeatNotFoundException("Seat not found");
		}
		return ans;
	}

}
