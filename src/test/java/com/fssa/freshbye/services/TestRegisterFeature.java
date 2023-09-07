package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.*;
import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;

 class TestRegisterFeature {
	@Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("praveen@gmail.com", "praveen", "Patelab@1", "9092500612");

		try {
			assertTrue(userservice.registerUser(user1)); 
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("Registrtion failed");
 
		}

	}
  
	@Test 
	 void testRegistrationFail() throws DAOException {

		UserService userservice = new UserService();
		User user = new User("saran@gmail.com", "saran", "Wow@2002", "9092500612");

		try {
			assertTrue(userservice.registerUser(user));
		} catch (ServiceException e) {
			System.out.println("Registrtion failed");
		

		}

	}


}
