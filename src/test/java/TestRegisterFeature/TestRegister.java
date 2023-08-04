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

	public static void main(String[] args) {

		User user1 = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal123");
		UserService userService = new UserService();

		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal@123");
		try {

			assertTrue(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal@123");
		try {
			assertFalse(UserService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {

		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}