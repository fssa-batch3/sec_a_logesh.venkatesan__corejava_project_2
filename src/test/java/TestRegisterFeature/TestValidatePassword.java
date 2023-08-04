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
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal@123");
		
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test 
	public void testInvalidPasswordWithoutSpecialCharacters() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal123");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void testInvalidPasswordWithoutNumbers() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal@@@@@");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutSpecialAlphabets() throws ServiceException {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","@1234567");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordLengthlessThan8() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","Ajmal@1");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testInvalidPasswordWithoutUppercase() {
		
		UserService userService = new UserService();
		
		User user = new User("Username_784","Male" ,"9500320194","2004-12-26", "freekyajmal@gmail.com","ajmal@1234");
		
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

