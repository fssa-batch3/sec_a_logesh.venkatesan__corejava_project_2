package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.*;
import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;

 class TestRegisterFeature {
	 Logger logger = new Logger();
	 
	 @Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("ramu@gmail.com", "Ramu", "Ramu@1234", "9092500612");

		try {
			assertTrue(userservice.registerUser(user1)); 
		} catch (ServiceException e) {
			logger.error(e);	
			logger.debug("Registrtion failed");
 
		}

	}
  
	@Test 
	 void testRegistrationFail() throws DAOException {

		UserService userservice = new UserService();
		User user = new User("saran@gmail.com", "saran", "Wow@2002", "9092500612");

		try {
			assertTrue(userservice.registerUser(user));
		} catch (ServiceException e) {
			logger.debug("Registrtion failed");
		
 
		}

	}


}
