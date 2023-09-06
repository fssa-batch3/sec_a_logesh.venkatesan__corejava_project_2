package com.fssa.freshbye.service;

import java.sql.SQLException;

import com.fssa.freshbye.dao.UserDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.*;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getMail(), user.getPassword());

		try {
			if (UserValidator.validateUser(user) && !userDAO.EmailExist(user1)) {
				if (userDAO.register(user)) {
					System.out.println(user.getUsername() + " Successfully Registered! Welcome to freshBye");
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	// update user
	public boolean UpdateUser(User user, String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.Update(user, email)) {
				System.out.println("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	// delete user
	public boolean DeleteUser(User user, String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.Delete(user, email)) {
				System.out.println("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean LoginUser(String email, String password) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.login(email, password)) {
				System.out.println("\n" + email + " Login Successful!");
				return true;
			} else {
				System.out.println("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}