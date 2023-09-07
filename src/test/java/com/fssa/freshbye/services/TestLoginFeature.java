 package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;

 class TestLoginFeature {
 
	@Test
	 void loginSuccess() {
		UserService userService = new UserService();

		String email = "gopu@gmail.com";
		String password = "Wow@2002";
		try { 
			 
			assertTrue(userService.LoginUser(email, password));
			throw new ServiceException("Login successfully. Welcome, " + email + "!");
		} catch (ServiceException e) {
 
			System.out.println(e.getMessage());
		}
	}   
 
	@Test
	 void loginFailed() {
		UserService userService = new UserService();
		String email = "gopikan2906@gmail.com";
		String password = "Wow@2002";
		try {
			assertFalse(userService.LoginUser(email, password));
			throw new ServiceException("Login Failed.Kindly Register");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	} 
}
