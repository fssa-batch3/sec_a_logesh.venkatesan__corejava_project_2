package freshBYE.services;
import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import freshBYE.dao.*;
import freshBYE.model.User;
import freshBYE.services.*;
import freshBYE.services.exception.serviceException;
import freshBYE.validation.UserValidator;
import freshBYE.validation.exception.InvalidUserException;

public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
		if(UserValidator.ValidateUser(user)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getUserName() + " Successfully Registered!");
				return true;
			} else {
				System.out.println("Registration not successful!");
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public static boolean LoginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if(userDAO.login(user)) {
				System.out.println("\n" + user.Email + " Login Successful!");
				return true;
			} else {
				System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
}
