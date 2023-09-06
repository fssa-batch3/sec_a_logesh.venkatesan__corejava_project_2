package com.fssa.freshbye.service;

import java.util.List;

import com.fssa.freshbye.dao.PostDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class PostService {
//	post createService feature

	public boolean createPost(Post post) throws ServiceException, InvalidPostException, InvalidUserException {

		PostDAO postDAO = new PostDAO();

		try { 
			PostValidation.validatePost(post);
            return postDAO.createPost(post);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	} 

//	Fundraise view service feature
	public List<Post> viewPost() throws ServiceException {
		PostDAO postDAO = new PostDAO();

		try {
			return postDAO.viewPost();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

//	Update post feature Service

	public boolean updatePost(Post post) throws ServiceException {

		PostDAO postDAO = new PostDAO();

		try {
			//PostValidation.validateTitle(post);

			if (postDAO.createPost(post)) {
				System.out.println("Update Post for post was successfull");
				return true;
			} else {
				System.out.println("Update Post was not successfull");
				return false;

			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}



	public boolean deletePost(int postId) throws ServiceException {
		PostDAO postDAO = new PostDAO();
		try {

			if (postDAO.deletePost(postId)) {
				System.out.println("Successfully deleted the post details");
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

	
}