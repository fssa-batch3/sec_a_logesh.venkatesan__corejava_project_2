package freshBYE.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import freshBYE.model.User;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root","780808");
	 return connection;
	}
	
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
		
	   
	   Connection connection = getConnection();
	   
	   String selectQuery = "SELECT * FROM user WHERE Email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.Email);
	   ResultSet resultSet = pst.executeQuery();
	   
	   while (resultSet.next()) {
		   String emailID = resultSet.getString("email");
		   String Password = resultSet.getString("password");
		   
		   System.out.println("Email: " + emailID + " Password: " + Password);
		   
		   if(user.getEmail().equals(emailID) && user.getPassword().equals(Password)) {
			   match = true;
		   }
	   }
	   return match;
	}
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user (UUID,UserName,Email,Password,Mobile,profile) VALUES (?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUUID());
		pst.setString(2, user.getUserName());
		pst.setString(5, user.getMobile_number());
		pst.setString(6, user.getProfile());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
}
