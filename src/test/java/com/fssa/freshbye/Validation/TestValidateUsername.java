package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestValidateUsername {
	@Test
	 void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("Soffan"));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	} 
 
	@Test
	 void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("1Soffan"));

		} catch (InvalidUserException e) {
			System.out.println("username should not start with number");

		}
	}

	@Test
	public void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("@soffan"));
			System.out.println("username should not contains special character");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("Soffan gk"));
			System.out.println("username should not contains spaces ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooShort() {
		try {

			assertFalse(UserValidator.validateName("So"));
			System.out.println("username should not be too small ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Sofannnnnnnnnnnnnnnnnnnnnnnnnna"));
			System.out.println("username should not be too long ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}
