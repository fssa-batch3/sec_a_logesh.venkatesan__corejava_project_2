package com.fssa.freshbye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.freshbye.dao.exceptions.*;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;

public class LikeDAO {
	
	
	    Logger logger = new Logger();

	    public boolean likePost(String userId, int postId) throws DAOException {
	        String query = "UPDATE LikePost SET IsLiked = 1 WHERE UserMail = ? AND PostID = ?";

	        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, userId);
	            ps.setInt(2, postId);

	            int rows = ps.executeUpdate(); 

	            return rows == 1;
	        } catch (SQLException e) {
	            throw new DAOException("Error in liking the post", e);
	        }
	    }

	    public boolean addLike(String userId, int postId) throws DAOException {
	        String query = "INSERT INTO LikePost (UserMail, PostID, IsLiked) VALUES (?, ?, 1)";

	        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, userId);
	            ps.setInt(2, postId);

	            int rows = ps.executeUpdate();

	            return rows == 1;
	        } catch (SQLException e) {
	            throw new DAOException("Error in adding like to the post", e);
	        }
	    }

	    public static int getLikeCount(int postId) throws DAOException {
	        String query = "SELECT COUNT(*) FROM LikePost WHERE PostID = ? AND IsLiked = 1";

	        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setInt(1, postId);

	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getInt(1);
	                } else {
	                    return 0;
	                }
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Error in getting like count for the post", e);
	        }
	    }


}
