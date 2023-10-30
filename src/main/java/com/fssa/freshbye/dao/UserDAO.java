package com.fssa.freshbye.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.PasswordEncryptAndDecryptService;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;

public class UserDAO {
	Logger logger = new Logger();

	boolean match = false;

	/*
	 * Get user from DB - Login
	 */
	public boolean login(String email, String password) throws DAOException, SQLException {
	    String query = "SELECT user_pwd FROM userdata WHERE user_mail = ?";
	    try (Connection con = Utils.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setString(1, email);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (!rs.next()) {
	                logger.debug("1");
	                throw new DAOException("Invalid Login Credentials");
	            } else {
	                String encryptedPassword = rs.getString("user_pwd");
	               
	                if (encryptedPassword != null && !encryptedPassword.equals(password)) {
	                    logger.debug("User credential not same");
	                    throw new DAOException("Invalid Login Password");
	                

	                } else {
	                    // User has logged in successfully, so update is_active to 1
	                    String updateQuery = "UPDATE userdata SET is_active = 1 WHERE user_mail = ?";
	                    try (PreparedStatement updatePs = con.prepareStatement(updateQuery)) {
	                        updatePs.setString(1, email);
	                        updatePs.executeUpdate();
	                    }
	                }
	            }
	        }
	    }
	    return true;
	}


	public boolean emailExist(User user) throws SQLException {
		boolean isMatch = false;
		String selectQuery = "SELECT * FROM userdata WHERE user_mail = ?";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setString(1, user.getMail());
			try (ResultSet resultSet = pst.executeQuery()) {
				while (resultSet.next()) {
					String emailID = resultSet.getString("user_mail");
					String password = resultSet.getString("user_pwd");

					logger.debug("Email: " + emailID + " Password: " + password);

					if (user.getMail().equals(emailID)) {
						isMatch = true;
					}
				}
			}
		}
		return isMatch;
	}

	public boolean register(User user) throws SQLException {
		String insertQuery = "INSERT INTO userdata (user_name,user_mail,mobileno,user_pwd,profileImage) VALUES (?,?,?,?,?);";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getMail());
			pst.setString(3, user.getMobileno());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getProfileImage());
			int rows = pst.executeUpdate();

			return (rows == 1);
		}
	}

	public User getProfile(String userMail) throws SQLException {
		User user = null;
		String selectQuery = "SELECT user_name, user_mail, mobileno, profileImage,user_pwd FROM userdata WHERE user_mail = ?;";

		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setString(1, userMail);
			ResultSet resultSet = pst.executeQuery();

			if (resultSet.next()) {
				String userName = resultSet.getString("user_name");
				String UserMail = resultSet.getString("user_mail");
				String mobileNo = resultSet.getString("mobileno");
				String profileImage = resultSet.getString("profileImage");
				String password = resultSet.getString("user_pwd");

				user = new User(UserMail, userName, password, mobileNo, profileImage);
			}
		}

		return user;
	}
	
	public static List<User> getAllUsers() throws DAOException, SQLException {
	    List<User> users = new ArrayList<>();
	    String selectQuery = "SELECT user_name, user_mail, mobileno, profileImage, user_pwd FROM userdata;";

	    try (Connection connection = Utils.getConnection();
	            PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        ResultSet resultSet = pst.executeQuery();

	        while (resultSet.next()) {
	            String userName = resultSet.getString("user_name");
	            String userMail = resultSet.getString("user_mail");
	            String mobileNo = resultSet.getString("mobileno");
	            String profileImage = resultSet.getString("profileImage");
	            String password = resultSet.getString("user_pwd");

	            User user = new User(userMail, userName, password, mobileNo, profileImage);
	            users.add(user);
	        }
	    }

	    return users;
	}


	public boolean update(User user) throws SQLException {
		String selectQuery = "UPDATE userdata SET   user_name = ?,mobileno = ?,user_pwd = ?,profileImage=? WHERE user_mail = ?;";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getMobileno());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getProfileImage());
			pst.setString(5, user.getMail());
			int rows = pst.executeUpdate();
			return (rows == 1);
		}
	}

	public boolean delete(int userId) throws SQLException {
		int isDelete = 1;
		String selectQuery = "UPDATE userdata SET is_deleted = ? WHERE id = ?";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setInt(1, isDelete);
			pst.setInt(2, userId);
			int rows = pst.executeUpdate();
			return (rows == 1);
		}
	}

	public boolean logout(int userId) throws SQLException {
		int isActive = 1;
		String selectQuery = "UPDATE userdata SET is_active = ? WHERE id = ?";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setInt(1, isActive);
			pst.setInt(2, userId);
			int rows = pst.executeUpdate();
			return (rows == 1);
		}
	}

	public int getIdByEmail(String email) throws SQLException {
		String selectQuery = "SELECT id FROM userdata WHERE user_mail = ?";
		try (Connection connection = Utils.getConnection();
				PreparedStatement pst = connection.prepareStatement(selectQuery)) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			} else {
				throw new SQLException("No user found with this email"+email);
			}
		}
	}

}