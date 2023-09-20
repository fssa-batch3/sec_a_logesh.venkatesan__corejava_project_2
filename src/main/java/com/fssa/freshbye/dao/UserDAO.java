package com.fssa.freshbye.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;

public class UserDAO {
	 Logger logger = new Logger();

	boolean match = false;
/*	
 * Get user from DB - Login
 * */
	public boolean login(String email, String password) throws DAOException, SQLException {
	    String query = "SELECT user_pwd FROM userdata WHERE user_mail = ?";
	    try (Connection con = Utils.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setString(1, email);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (!rs.next()) {
	                logger.debug("1");
	                throw new DAOException("Invalid Login Credentials");
	            } else {
	                if (!rs.getString("user_pwd").equals(password)) {
	                    logger.debug("2");
	                    throw new DAOException("Invalid Login Credentials");
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
	    } catch (SQLException e) {
	       logger.error(e);
	        throw new DAOException(e.getMessage());
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
	                String password  = resultSet.getString("user_pwd");

	             logger.debug("Email: " + emailID + " Password: " + password );

	                if (user.getMail().equals(emailID)) {
	                	isMatch = true;
	                }
	            }
	        }
	    }
	    return isMatch;
	}

   
   
	public boolean register(User user) throws SQLException {
	    String insertQuery = "INSERT INTO userdata (user_name,user_mail,mobileno,user_pwd) VALUES (?,?,?,?);";
	    try (Connection connection = Utils.getConnection();
	         PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	        pst.setString(1, user.getUsername());
	        pst.setString(2, user.getMail());
	        pst.setString(3, user.getMobileno());
	        pst.setString(4, user.getPassword());
	        int rows = pst.executeUpdate();
	        return (rows == 1);
	    }
	}

	
	
	public boolean update(User user ) throws SQLException {
	    String selectQuery = "UPDATE userdata SET  user_name = ?,mobileno = ?,user_pwd = ? WHERE user_mail = ?;";
	    try (Connection connection = Utils.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        pst.setString(1, user.getUsername());
	        pst.setString(2,user.getMobileno());
	        pst.setString(3, user.getPassword());
	        pst.setString(4, user.getMail());
	        int rows = pst.executeUpdate();
	        return (rows == 1);
	    }
	}

	
	
	
	public boolean delete(String email) throws SQLException {
	    int isDelete = 1;
	    String selectQuery = "UPDATE userdata SET is_deleted = ? WHERE user_mail = ?";
	    try (Connection connection = Utils.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        pst.setInt(1, isDelete);
	        pst.setString(2, email);
	        int rows = pst.executeUpdate();
	        return (rows == 1);
	    }
	}


	
}