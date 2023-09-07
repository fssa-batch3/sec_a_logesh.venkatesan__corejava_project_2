 package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

 class TestLoginFeature {
 Logger logger = new Logger();
	@Test
	 void loginSuccess() {
		UserService userService = new UserService();

		String email = "ramu@gmail.com";
		String password = "Ramu@1234";
		try { 
			 
			assertTrue(userService.loginUser(email, password));
			throw new ServiceException("Login successfully. Welcome, " + email + "!");
		} catch (ServiceException e) {
  
			logger.debug(e.getMessage());
		}
	}   
 
	@Test
	 void loginFailed() {
		UserService userService = new UserService();
		String email = "gopikan2906@gmail.com";
		String password = "Wow@2002";
		try {
			assertFalse(userService.loginUser(email, password));
			throw new ServiceException("Login Failed.Kindly Register");
		} catch (ServiceException e) {
			logger.debug(e.getMessage());
		}
	} 
}
