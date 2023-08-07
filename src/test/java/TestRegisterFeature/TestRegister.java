package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshBYE.model.User;
import freshBYE.services.UserService;
import freshBYE.services.exception.serviceException;

public class TestRegister {

	public static void main(String[] args) throws ServiceException {

		User user1 = new User("gogesh","9500320194","http//iamlokeshbharathi20%of12%me", "gogesh@gmail.com","Logesh@123");
		UserService userService = new UserService();
			userService.registerUser(user1);

	}

	@Test
	public void testRegistrationSuccess() throws ServiceException {
		UserService userService = new UserService();
		User user1 = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "gogesh@gmail.com","Logesh@123");
			assertTrue(UserService.registerUser(user1));
	}

//	@Test
//	public void testInvalidPassword() throws ServiceException {
//
//		UserService userService = new UserService();
//		User user1 = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "gogesh@gmail.com","logesh123");
//			assertFalse(UserService.registerUser(user1));
//		
//	}



}