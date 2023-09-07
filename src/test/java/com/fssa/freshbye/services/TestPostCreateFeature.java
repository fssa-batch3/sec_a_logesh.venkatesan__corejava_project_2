package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fssa.freshbye.utils.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

class TestPostCreateFeature {
	 Logger logger = new Logger();
	@Test
	void testCreateValid() throws InvalidPostException, InvalidUserException {
		User user = new User();
		Post post = new Post();
		user.setUsername("Raamu");
	 
 
		
		post.setPostImage(
				"https://welcome-to-freshbye-dude");
		post.setTitle("Happy boli");
		post.setDescription("I am enjoy the fest of boli in my college with my friends");
		post.setUserId(5);
		PostService postservice = new PostService();
		try {
			assertTrue(postservice.createPost(post));
		} catch (ServiceException e) {
 		logger.error(e);	
		}
	} 
 
	

	@Test
	void testCreateInvalid() throws InvalidPostException, InvalidUserException {
		User user = new User();
		user.getUsername();
		Post post = new Post();
PostService postservice = new PostService();
		post.setTitle(null);
		post.setPostImage(null);
				post.setDescription(null);
		

		try {
			assertFalse(postservice.createPost(post));
			logger.debug("Failed to create an invalid Post");
		} catch (ServiceException e) {
			logger.error(e);	
		}
	}

}
