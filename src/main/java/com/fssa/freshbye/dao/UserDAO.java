package com.fssa.freshbye.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.utils.Utils;

public class UserDAO {


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
	                System.out.println("1");
	                throw new DAOException("Invalid Login Credentials");
	            } else {
	                if (!rs.getString("user_pwd").equals(password)) {
	                    System.out.println("2");
	                    throw new DAOException("Invalid Login Credentials");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DAOException(e.getMessage());
	    }
	    return true;
	}

   
	public boolean EmailExist(User user) throws SQLException {
	    boolean match = false;
	    String selectQuery = "SELECT * FROM userdata WHERE user_mail = ?";
	    try (Connection connection = Utils.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        pst.setString(1, user.getMail());
	        try (ResultSet resultSet = pst.executeQuery()) {
	            while (resultSet.next()) {
	                String emailID = resultSet.getString("user_mail");
	                String Password = resultSet.getString("user_pwd");

	                System.out.println("Email: " + emailID + " Password: " + Password);

	                if (user.getMail().equals(emailID)) {
	                    match = true;
	                }
	            }
	        }
	    }
	    return match;
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

	
	
	public boolean Update(User user , String email) throws SQLException {
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

	
	
	
	public boolean Delete(User user1 , String email) throws SQLException {
	    int is_delete = 1;
	    String selectQuery = "UPDATE userdata SET is_deleted = ? WHERE user_mail = ?";
	    try (Connection connection = Utils.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        pst.setInt(1, is_delete);
	        pst.setString(2, email);
	        int rows = pst.executeUpdate();
	        return (rows == 1);
	    }
	}
}