package com.fssa.freshbye.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshbye.dao.PostDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.utils.Utils;
import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class PostService {

	 Logger logger = new Logger();
	public boolean createPost(Post post) throws ServiceException, InvalidPostException, InvalidUserException {

		PostDAO postDAO = new PostDAO();

		try { 
			PostValidation.validatePost(post);
            return postDAO.createPost(post);
		} catch (DAOException e) { 
			throw new ServiceException(e.getMessage(), e);
		}
	} 

	public List<Post> viewPost() throws ServiceException {
		PostDAO postDAO = new PostDAO();
		try {
			return postDAO.viewPost();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	public List<Post> viewMyPost(String userMail) throws ServiceException {
	    PostDAO postDAO = new PostDAO();
	    try {
	        return postDAO.myPost(userMail);
	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage(), e);
	    }
	}


	public boolean updatePost(String userEmail, int postId, Post post) throws ServiceException {
	    PostDAO postDAO = new PostDAO();

	    try {
	       

	        if (postDAO.updatePost(userEmail, postId, post)) {
	            logger.debug("Update Post for post was successful");
	            return true;
	        } else {
	            logger.debug("Update Post was not successful");
	            return false;
	        }

	    } catch (DAOException e) {
	        throw new ServiceException(e.getMessage(), e);
	    }
	}

	private int getUserIdByEmail(String userEmail) {
	    return 0;
	}




	public boolean deletePost(int postId) throws ServiceException {
		PostDAO postDAO = new PostDAO();
		try {

			if (postDAO.deletePost(postId)) {
				logger.debug("Successfully deleted the post details");
				return true;
			} else {

				return false;
			} 

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

	  public int postGetPostId() throws ServiceException {
		  PostDAO postDAO = new PostDAO();
	        try {
	            return postDAO.getUserIDFromPost(); 
	        } catch (DAOException e) {
	            throw new ServiceException("Error getting post ID", e);
	        }
	    }

	  public boolean blockPost(String userId, int postId) throws ServiceException {
		  PostDAO postDAO = new PostDAO();
			try {

				if (postDAO.blockPost(userId, postId)) {
					logger.debug("Successfully Block the post details");
					return true;
				} else {

					return false;
				} 

			} catch (DAOException e) {

				throw new ServiceException(e.getMessage(), e);
			}
	    }}
	 