package TestLoginFeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import freshBYE.model.User;
import freshBYE.services.UserService;

public class TestLogin {

	public static void main(String[] args) {

		User user1 = new User("logesh@gmail.com","logesh@123");
		UserService userService = new UserService();

		try {
			userService.LoginUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestValidUser() throws ServiceException {
		User user1 = new User("logesh@gmail.com","logesh@123");
		assertTrue(UserService.LoginUser(user1));
	}
	
	@Test
	public void TestInValidUser() throws ServiceException {
		User user1 = new User("bharathi@gmail.com","bharathi@123");
		assertFalse(UserService.LoginUser(user1));
	}
	
}
