package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.UserService;
import com.fssa.freshbye.service.exception.ServiceException;

class TestUpdateUserFeature {

/*
 * Success test case for update features
 */ 
	@Test
	void testUpdateSuccess() {

		UserService userservice = new UserService();

		User user1 = new User("Vinittechcouch@gmail.com", "IamVinit", "Panels@1", "8270853318");

		try {
			assertTrue(userservice.UpdateUser(user1, "gopikannan@gmail.com"));
		} catch (ServiceException e) {

			System.out.println(e.getMessage());

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
			assertFalse(userservice.UpdateUser(user1, "gopikannan@gmail.com"));
		} catch (ServiceException e) {

			System.out.println(e);

		}

	}

}
