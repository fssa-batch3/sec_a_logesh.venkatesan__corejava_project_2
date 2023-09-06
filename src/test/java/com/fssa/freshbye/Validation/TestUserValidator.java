package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.User;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

class TestUserValidator {
	@Test
	void testValidUser() throws InvalidUserException {
		User user1 = new User("gopikannani2906@gmail.com", "Gopikannan", "Wow@2002", "9092500612");
		boolean isValid = UserValidator.validateUpdateUser(user1);
		assertTrue(isValid);
	}

	@Test
	void testInvalidUser() {
		User invalidUser = new User(null, null, null, null);

		assertThrows(InvalidUserException.class, () -> {
			UserValidator.validateUpdateUser(invalidUser);
		});
	}
}
  