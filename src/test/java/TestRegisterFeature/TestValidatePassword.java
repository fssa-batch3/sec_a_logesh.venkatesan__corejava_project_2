package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshBYE.model.User;
import freshBYE.services.UserService;

public class TestValidatePassword {

	@Test 
	public void testValidPassword() {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","Logesh@123");
		
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testInvalidPasswordWithoutSpecialCharacters() {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","Logesh123");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void testInvalidPasswordWithoutNumbers() {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","logesh");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutSpecialAlphabets() throws ServiceException {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","899123");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordLengthlessThan8() {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","Logesh3");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutUppercase() {
		
		UserService userService = new UserService();
		
		User user = new User("Logesh","9500320194","http//iamlokeshbharathi20%of12%me", "logesh@gmail.com","logesh123");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

