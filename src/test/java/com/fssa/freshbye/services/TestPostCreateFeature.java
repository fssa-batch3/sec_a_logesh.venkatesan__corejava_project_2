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
		
		Post post = new Post();
	  
 
		
		post.setPostImage(
				"https://ca.slack-edge.com/T032648LE-U041S8KPAUV-3be23a23657d-512");
		post.setTitle("Karthick");
		post.setDescription("Click with mirror");
		post.setUserMail("gopikannan@gmail.com");
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
			logger.debug("Failed to create an invalid Post because of invalid or null credential");
		} catch (ServiceException e) {
			logger.debug(e);	
		}
	}

}
