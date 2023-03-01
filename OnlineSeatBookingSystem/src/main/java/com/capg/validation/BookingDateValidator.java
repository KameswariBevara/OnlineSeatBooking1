package com.capg.validation;

import java.time.LocalDate;
import java.time.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookingDateValidator implements ConstraintValidator<ValidBookingDate, LocalDate> {

	@Override
	public boolean isValid(LocalDate bookingDate, ConstraintValidatorContext context) {
		if (bookingDate == null) {
			return false;
		}
		LocalDate currentDate = LocalDate.now();
		if (bookingDate.isBefore(currentDate.withDayOfMonth(1))) {
			return false;
		}
		int daysInMonth = YearMonth.from(currentDate).lengthOfMonth();
		LocalDate lastDayOfMonth = currentDate.withDayOfMonth(daysInMonth);
		if (bookingDate.isAfter(lastDayOfMonth)) {
			return false;
		}
		return true;
	}
}
