package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.UserService;
import com.fssa.freshbye.service.exception.ServiceException;

class TestUpdateUserFeature {
	Logger logger = new Logger();

	/*
	 * Success test case for update features
	 */
	@Test
	void testUpdateSuccess() {

		UserService userservice = new UserService();

		User user1 = new User("ramu@gmail.com", "Ramu", "Raamu@1234", "8270853318");

		try {
			assertTrue(userservice.updateUser(user1));
		} catch (ServiceException e) {

			logger.debug(e.getMessage());
 
		}

	}

	/*
	 * failure test case for update features
	 */

	@Test
	void testUpdateFail() {

		UserService userservice = new UserService();

		User user1 = new User("vivky@2002", "VickyKannan", "Kon@2002", "9028848999");

		try {
			assertFalse(userservice.updateUser(user1));
		} catch (ServiceException e) {

			logger.debug(e);

		}

	}

}
