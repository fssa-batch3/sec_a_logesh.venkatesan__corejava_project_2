package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.UserService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

class TestUserProfileFeature {
	Logger logger = new Logger();

	@Test
	void testGetUserProfileValid() {
		UserService userService = new UserService();
		String validUserMail = "gopikannan@gmail.com";

		try {
			User userProfile = userService.getUserProfile(validUserMail);

			assertNotNull(userProfile);
			assertEquals(validUserMail, userProfile.getMail());
			logger.debug("User Profile for " + validUserMail + " : " + userProfile);

		} catch (ServiceException e) {
			logger.debug(e);
		}
	}

	@Test
	void testGetUserProfileInvalid() {
		UserService userService = new UserService();
		String invalidUserMail = "nonexistent@example.com";

		try {
			User userProfile = userService.getUserProfile(invalidUserMail);
			assertNull(userProfile);

		} catch (ServiceException e) {
			logger.debug(e);
		}
	}
}
