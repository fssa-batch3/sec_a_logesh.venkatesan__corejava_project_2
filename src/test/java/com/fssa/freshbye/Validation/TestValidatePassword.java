package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestValidatePassword {
	 Logger logger = new Logger();
	 
@Test
 void TestValidPassword() {
	try {
		
		assertTrue(UserValidator.validatePassword("Wow@2002"));
		logger.debug("The password is valid");
	} catch (InvalidUserException e) {
		logger.debug(e.getMessage());
	}
	
	
} 
@Test
 void TestInValidPassword() {
	try {
		
		assertFalse(UserValidator.validatePassword("Wow2002"));
		logger.debug("The password is not valid");
	} catch (InvalidUserException e) {
		
		logger.debug(e.getMessage());
	}
}

@Test
 void TestInValidPasswordWithoutNumbers() {
	try {
		
		assertFalse(UserValidator.validatePassword("Wow@"));
		logger.debug("The password is without numbers");
	} catch (InvalidUserException e) {
		
		logger.debug(e.getMessage());
	}
}
@Test
 void TestInValidPasswordWithoutCapitalLetters() {
	try {
		
		assertFalse(UserValidator.validatePassword("wow@2002"));
		logger.debug("The password is without Capital letters");
	} catch (InvalidUserException e) {
	
		logger.debug(e.getMessage());
	}
}
@Test
 void TestInValidPasswordWithoutSmallLetters() {
	try {
		
		assertFalse(UserValidator.validatePassword("WOW@2002"));
		logger.debug("The password is without small letters");
	} catch (InvalidUserException e) {
		
		logger.debug(e.getMessage());
	}
}
@Test
 void TestInValidPasswordShorterLength() {
	try {
		
		assertFalse(UserValidator.validatePassword("W@2002"));
		logger.debug("The password too short");
	} catch (InvalidUserException e) {
		logger.debug(e.getMessage());
	}
}

}
