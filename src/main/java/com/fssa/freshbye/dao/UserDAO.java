package com.fssa.freshbye.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.utils.Utils;

public class UserDAO {

	
	
	//connect to database
//	Utils utils = new Utils();
	boolean match = false;
//	Get user from DB - Login
   public boolean login(String email, String password) throws DAOException, SQLException {
		
	 
			Connection con = Utils.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String query = "SELECT user_pwd FROM userdata WHERE user_mail = ?";
				con = Utils.getConnection();
				ps = con.prepareStatement(query);
				ps.setString(1, email);
				rs = ps.executeQuery();
				
				if(rs.next() == false) {
					System.out.println("1");
					throw new DAOException("Invalid Login Credentials");
				}
				else{
					if(!rs.getString("user_pwd").equals(password)) {
						System.out.println("2");
						throw new DAOException("Invalid Login Credentials");
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			} finally {
				rs.close();
				ps.close();
				con.close();

			}
			return true;
		}
   
   //Email Not Exist
   public boolean EmailExist(User user) throws SQLException {
		
	   
	   Connection connection = Utils.getConnection();
	   
	   String selectQuery = "SELECT * FROM userdata WHERE user_mail = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.getMail());
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("user_mail");
		   String Password = resultSet.getString("user_pwd");
		   
		   System.out.println("Email: " + emailID + " Password: " + Password);
		   
		   if(user.getMail().equals(emailID)) {
			   match = true;
		   }
	   }
	   return match;
	}
   
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = Utils.getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO userdata (user_name,user_mail,mobileno,user_pwd) VALUES (?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
//		pst.setInt(1, user.getUserID());
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getMail());
		pst.setString(3,user.getMobileno());
		pst.setString(4, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
	
	// update user
	public boolean Update(User user , String email) throws SQLException {
		   
		   Connection connection = Utils.getConnection();
		   
		   String selectQuery = "UPDATE userdata SET  user_name = ?,mobileno = ?,user_pwd = ? WHERE user_mail = ?;";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		  
		   pst.setString(1, user.getUsername());
			pst.setString(2,user.getMobileno());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getMail());
		   
		 //Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1); 
}
	
	//delete user
	// update user
	public boolean Delete(User user1 , String email) throws SQLException {
		   
		   Connection connection = Utils.getConnection();
		   
		   int is_delete = 1;
		   
		   String selectQuery = "UPDATE userdata SET is_deleted = ? WHERE user_mail = " + email + ";";
		   PreparedStatement pst = connection.prepareStatement(selectQuery);
		   pst.setInt(1, is_delete);
		   
		 //Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
}
	
}