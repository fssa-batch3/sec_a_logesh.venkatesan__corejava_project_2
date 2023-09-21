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
				"https://th.bing.com/th/id/OIP.sTg2ki8pNQsvGKfe6WLjvQHaEK?w=328&h=184&c=7&r=0&o=5&dpr=1.5&pid=1.7");
		post.setTitle("Hey! Peter");
		post.setDescription("Spiderman Noway Home");
		post.setUserMail("gopikannan@gmail.com");
		post.setpostId(1);
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
