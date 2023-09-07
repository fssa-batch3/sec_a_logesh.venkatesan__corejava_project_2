package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestValidateUsername {
	 Logger logger = new Logger();
	@Test
	 void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("Soffan"));
			logger.debug("username is valid");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	} 
 
	@Test
	 void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("1Soffan"));

		} catch (InvalidUserException e) {
			logger.debug("username should not start with number");

		}
	}

	@Test
	public void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("@soffan"));
			logger.debug("username should not contains special character");
		} catch (InvalidUserException e) {

			logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("Soffan gk"));
			logger.debug("username should not contains spaces ");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooShort() {
		try {

			assertFalse(UserValidator.validateName("So"));
			logger.debug("username should not be too small ");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Sofannnnnnnnnnnnnnnnnnnnnnnnnna"));
			logger.debug("username should not be too long ");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}
}
