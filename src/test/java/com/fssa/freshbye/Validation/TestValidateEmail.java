package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class TestValidateEmail {
	 Logger logger = new Logger();
	
	@Test
	void testValidEmail() {

		try {

			assertTrue(UserValidator.validateEmail("soffan2906@gmail.com"));
			logger.debug("Your email is valid");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906gmail.com"));
			logger.debug("Your email is not valid");
		} catch (InvalidUserException e) {
			logger.debug("Your email is valid");
		}
	}

	@Test
	void testInvalidEmailWithoutcom() {
		try {
			assertFalse(UserValidator.validateEmail("soffan2906@"));
			logger.debug("Your email is not valid");

		} catch (InvalidUserException e) {
			logger.debug("Your email is valid");
		} 
	}

}
 