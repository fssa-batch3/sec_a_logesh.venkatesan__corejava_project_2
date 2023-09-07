package com.fssa.freshbye.service;

import java.sql.SQLException;

import com.fssa.freshbye.dao.UserDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.*;

public class UserService {

	 Logger logger = new Logger();
	 
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getMail(), user.getPassword());

		try {
			if (UserValidator.validateUser(user) && !userDAO.emailExist(user1)) {
				if (userDAO.register(user)) {
					logger.debug(user.getUsername() + " Successfully Registered! Welcome to freshBye");
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
	public boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.update(user)) {
				logger.debug("User Details Successfully Updated!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	// delete user
	public boolean deleteUser(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.delete(email)) {
				logger.debug("User Details Successfully Deleted!");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean loginUser(String email, String password) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.login(email, password)) {
				logger.debug("\n" + email + " Login Successful!");
				return true;
			} else {
				logger.debug("\n" + " Login Not Successful! ReCheck Your Credentials");
				return false;
			}
		} catch (SQLException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}