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
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","root");
	 return connection;
	}
	
	boolean match = false;
//	Get user from DB - Login
   public boolean login(User user) throws SQLException {
		
	   
	   Connection connection = getConnection();
	   
	   String selectQuery = "SELECT * FROM user WHERE email = ?";
	   PreparedStatement pst = connection.prepareStatement(selectQuery);
	   pst.setString(1, user.email);
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
		String insertQuery = "INSERT INTO user (userID,username,gender,mobile_number,date_of_birth,email,password) VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUserID());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getGender());
		pst.setString(4, user.getMobile_number());
		pst.setString(5, user.getDate_of_birth());
		pst.setString(6, user.getEmail());
		pst.setString(7, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
}
