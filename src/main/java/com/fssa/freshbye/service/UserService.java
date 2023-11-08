package com.fssa.freshbye.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.freshbye.dao.UserDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.validation.UserValidator;
import com.fssa.freshbye.validation.exceptions.*;

public class UserService {

	 static Logger logger = new Logger();
	 
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		User user1 = new User(user.getMail(), user.getPassword());
		
		try {
			if (UserValidator.validateUser(user) && !userDAO.emailExist(user1)) {
				logger.debug("Email Exist"+userDAO.emailExist(user1));
				if (userDAO.register(user)) {
					logger.debug("DAO process cleared");
					logger.debug(user.getUsername() + " Successfully Registered! Welcome to freshBye");
					logger.debug("Validation process cleared");
					return true;
				} else {
					logger.debug("DAO process not cleared");
					
					return false;
				}
				
			} else {
				logger.debug("Validation process not cleared");
				//throw new ServiceException("");
				return false;
			}
		} catch (SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	//User Profile
	public User getUserProfile(String userMail) throws ServiceException {
	    UserDAO userDAO = new UserDAO();

	    try {
	    	  return userDAO.getProfile(userMail);
	    } catch (SQLException e) {
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
	public boolean deleteUser(int usedId) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.delete(usedId)) {
				logger.debug("User Details Successfully Deleted!");
				return true;
			} else {
				logger.debug("User Details not Successfully Deleted!");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	
	public static boolean logoutAccount(int usedId) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.logout(usedId)) {
				logger.debug("User  Successfully Logout");
				return true;
			} else {
				logger.debug("User not Successfully Loggedout");
				return false;
			}
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}
	


	   public static List<User> getAllUsers() throws ServiceException, DAOException {
	        try {
	            return UserDAO.getAllUsers();
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }
	

	
	public static int getIdByEmailService(String email) throws ServiceException {
	    UserDAO userDAO = new UserDAO();
	    try {
	        int id = userDAO.getIdByEmail(email);
	        if (id != -1) {
	            logger.debug("User ID found!");
	            return id;
	        } else {
	            logger.debug("No user found with this email!");
	            return -1;
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
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

}