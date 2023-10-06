package com.fssa.freshbye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;

public class PostDAO {
	Logger logger = new Logger();

	/*
	 * CreatePost Method is used for create or register the user in our website via
	 * insert data to Db
	 */
	public boolean createPost(Post post) throws DAOException {

		String query = "INSERT INTO Postdetails (image_url, title, story, user_mail) VALUES (?, ?, ?,?)";

		try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, post.getPostImage());
			ps.setString(2, post.getTitle());
			ps.setString(3, post.getDescription());
			ps.setString(4, post.getUserMail());

			int rows = ps.executeUpdate();

			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in inserting Post in table", e);
		}
	}
	
	/*
	 * Here we list of my post the feature using query and connect with DB
	 */
	public List<Post> myPost(String email) throws DAOException {
	    List<Post> posts = new ArrayList<>();

	    String query = "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, Postdetails.image_url,Postdetails.post_id, Postdetails.title, Postdetails.story, Postdetails.user_mail FROM userdata INNER JOIN Postdetails ON userdata.user_mail = Postdetails.user_mail WHERE Postdetails.is_deleted = 0 AND Postdetails.is_spam=0 AND userdata.user_mail = ?";

	    try (Connection connection = Utils.getConnection();
	            PreparedStatement ps = connection.prepareStatement(query)) {

	        ps.setString(1, email); // Set the email parameter

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Post post = new Post();
	                post.setUsername(rs.getString("user_name"));
	                post.setUserMail(rs.getString("user_mail"));
	                post.setPostImage(rs.getString("image_url"));
	                post.setTitle(rs.getString("title"));
	                post.setDescription(rs.getString("story"));
	                post.setpostId(rs.getInt("post_id"));

	                // You need to create and set user information here

	                System.out.println(post);
	                posts.add(post);
	            }
	        }

	    } catch (SQLException e) {
	        logger.error(e);
	        throw new DAOException("Error reading Post from the table");
	    }
	    return posts;
	}


	/*
	 * Here we list the feature using query and connect with DB
	 */
	public List<Post> viewPost() throws DAOException {
		List<Post> posts = new ArrayList<>();

		String query = "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, Postdetails.image_url,Postdetails.post_id, Postdetails.title, Postdetails.story, Postdetails.user_mail FROM userdata INNER JOIN Postdetails ON userdata.user_mail = Postdetails.user_mail WHERE Postdetails.is_deleted = 0";

		try (Connection connection = Utils.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Post post = new Post();
				post.setUsername(rs.getString("user_name"));
				post.setUserMail(rs.getString("user_mail"));
				post.setPostImage(rs.getString("image_url"));
				post.setTitle(rs.getString("title"));
				post.setDescription(rs.getString("story"));
				post.setpostId(rs.getInt("post_id"));

				// You need to create and set user information here

				System.out.println(post);
				posts.add(post);

			}

		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException("Error reading Post from the table");
		}
		return posts;
	}
	/*
	 * Here we our own list the feature using query and connect with DB
	 */

	
	/*
	 * Here we can update our credentials via updatePost method
	 */
	public boolean updatePost(int id, Post post) throws DAOException {
		try {
			String query = "UPDATE Postdetails SET title = ?, story = ? WHERE post_id = ?";

			try (PreparedStatement ps = Utils.getConnection().prepareStatement(query)) {

				ps.setString(1, post.getTitle());
				ps.setString(2, post.getDescription());
				ps.setInt(3, id);

				int rows = ps.executeUpdate();
				return (rows == 1);
			}
		} catch (SQLException e) {
			logger.error(e);
			throw new DAOException("Error updating Post in the table");
		}
	}

	/*
	 * Here we can Delete our Account if needed via deletePost method
	 */
	public boolean deletePost(int postId) throws DAOException {
		String deleteQuery = "DELETE from Postdetails WHERE post_id=?";
		try (PreparedStatement ps = Utils.getConnection().prepareStatement(deleteQuery)) {

			ps.setInt(1, postId);
			int rows = ps.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in delete product method", e);
		}
	}

	/*
	 * Here we can Get UerId from post via getUserIdFromPost method
	 */
	public int getUserIDFromPost() throws DAOException {
		String query = "SELECT user_id FROM Postdetails WHERE post_id = (SELECT MAX(post_id) FROM Postdetails)\n" + "";

		try (PreparedStatement ps = Utils.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new DAOException("Error getting latest post id");
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting latest post id", e);
		}
	}

	public boolean blockPost(String userId, int postId) throws DAOException {
		String query = "UPDATE Postdetails SET is_spam = 1 WHERE user_mail = ? AND post_id = ?";

		try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, userId);
			ps.setInt(2, postId);

			int rows = ps.executeUpdate();

			return rows == 1;
		} catch (SQLException e) {
			logger.debug("Exception occurred: " + e.getMessage());
			e.printStackTrace();
			throw new DAOException("Error in blocking the post", e);
		}
	}
}
