package com.fssa.freshbye.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.freshbye.dao.exceptions.*;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;

public class CommentDAO {
    Logger logger = new Logger();

    public boolean addComment(String userId, int postId, int commentId, String commentMessage) throws DAOException {
        String query = "INSERT INTO Comment (UserMail, PostID, CommentId, CommentMessage) VALUES (?, ?, ?, ?)";

        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, userId);
            ps.setInt(2, postId);
            ps.setInt(3, commentId);
            ps.setString(4, commentMessage);

            int rows = ps.executeUpdate();

            return rows == 1;
        } catch (SQLException e) {
            throw new DAOException("Error in adding comment to the post", e);
        }
    }

    public String getComment(int postId) throws DAOException {
        String query = "SELECT CommentMessage FROM Comment WHERE PostID = ?";

        try (Connection connection = Utils.getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, postId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(1);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error in getting comment for the post", e);
        }
    }
}
