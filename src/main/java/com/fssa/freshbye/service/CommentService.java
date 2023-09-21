package com.fssa.freshbye.service;

import com.fssa.freshbye.dao.CommentDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

public class CommentService {
    Logger logger = new Logger();

    public boolean addComment(String userId, int postId, int commentId, String commentMessage) throws ServiceException {
        CommentDAO commentDAO = new CommentDAO();

        try {
            if(userId == null) {
                throw new ServiceException("Invalid userId: " + userId);
            }
            return commentDAO.addComment(userId, postId, commentId, commentMessage);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public String getComment(int postId) throws ServiceException {
        CommentDAO commentDAO = new CommentDAO();

        try {
            if(postId <= 0) {
                throw new ServiceException("Invalid postId: " + postId);
            }
            return commentDAO.getComment(postId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
