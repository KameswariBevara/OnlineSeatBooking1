package com.capg.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { BookingDateValidator.class })
@Documented
public @interface ValidBookingDate {
	String message() default "Booking date should be in the current month";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

