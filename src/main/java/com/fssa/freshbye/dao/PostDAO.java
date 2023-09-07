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
	 * CreatePost Method is used for create or register the user in our website via insert data to Db
	 * */
    public boolean createPost(Post post) throws DAOException {
    	
        String query = "INSERT INTO Postdetails (image_url, title, story, user_id) VALUES (?, ?, ?,?)";
        
        try (  Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, post.getPostImage());
            ps.setString(2, post.getTitle());
            ps.setString(3, post.getDescription());
            ps.setInt(4, post.getUserId());
             
             
            int rows = ps.executeUpdate();

            return rows == 1;
        } catch (SQLException e) {
            throw new DAOException("Error in inserting Post in table", e);
        }
    } 

  /*
   * Here we list the feature using query and connect with DB 
   * */
    public List<Post> viewPost() throws DAOException {
        List<Post> posts = new ArrayList<>();

        String query = "SELECT userdata.user_name, userdata.user_mail, userdata.mobileno, Postdetails.image_url, Postdetails.title, Postdetails.story, Postdetails.user_id FROM userdata INNER JOIN Postdetails ON userdata.id = Postdetails.user_id";
       
        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
         rs.getString("user_name");
               rs.getString("user_mail");
              rs.getString("mobileno");

                String postImage = rs.getString("image_url");
                String title = rs.getString("title");
                String description = rs.getString("story"); 
            rs.getInt("user_id");

                // You need to create and set user information here
                Post post = new Post(postImage, title, description);
                posts.add(post);
            }

        } catch (SQLException e) {
            logger.error(e);
            throw new DAOException("Error reading Post from the table");
        }
        return posts;
    }

/*
 * Here we can update our credentials via updatePost method 
 * */
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
     * */
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
     * Here we can Get UerId from post  via getUserIdFromPost method 
     * */
    public int getUserIDFromPost() throws DAOException {
        String query = "SELECT user_id FROM Postdetails WHERE post_id = (SELECT MAX(post_id) FROM Postdetails)\n"
        		+ "";

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
}
