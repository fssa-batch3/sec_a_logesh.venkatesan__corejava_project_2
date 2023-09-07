package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestValidateMobileNo {
	 Logger logger = new Logger();
	 
	 
	 
	 @Test
	 void testValidMobileNo() {
		try {
		
			assertTrue(UserValidator.validateMobileNo("9876543210"));
			logger.debug("Your mobile number is correct");
		} catch (InvalidUserException e) {

			  logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidMobileNoWithLessThan10Digits() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("987654321"));
			logger.debug("Mobile number should be in 10 digits only");
		} catch (InvalidUserException e) {

			logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidMobileNoWithMoreThan10Digits() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("98765432101"));
			logger.debug("Mobile number contains 10 digits only");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}

	@Test
	 void testInvalidMobileNoWithPrefixOtherThan6789() {
		try {
		
			assertFalse(UserValidator.validateMobileNo("5678901234"));
			logger.debug("Mobile number do not start with 5 ");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}

	@Test
	 void TestInvalidMobileNoWithNonNumericCharacters() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("9876a43210"));
			logger.debug("Mobile number contains integer");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());

		}
	}

	@Test
	 void testInvalidMobileNoStartingWithZero() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("0123456789"));
			logger.debug("Mobile number do not start with 0 ");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
		}
	}
}
