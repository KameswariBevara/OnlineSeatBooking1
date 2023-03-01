package com.capg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;

	private String seatNumber;

	private String seatLocation;

	private int seatFloor;

	private int floorCapacity;

	private int seatsAvailable;

	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatLocation() {
		return seatLocation;
	}

	public void setSeatLocation(String seatLocation) {
		this.seatLocation = seatLocation;
	}

	public int getSeatFloor() {
		return seatFloor;
	}

	public void setSeatFloor(int seatFloor) {
		this.seatFloor = seatFloor;
	}

	public int getFloorCapacity() {
		return floorCapacity;
	}

	public void setFloorCapacity(int floorCapacity) {
		this.floorCapacity = floorCapacity;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Seat(int seatId, String seatNumber, String seatLocation, int seatFloor, int floorCapacity,
			int seatsAvailable) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
		this.seatLocation = seatLocation;
		this.seatFloor = seatFloor;
		this.floorCapacity = floorCapacity;

		this.seatsAvailable = seatsAvailable;
	}

}
