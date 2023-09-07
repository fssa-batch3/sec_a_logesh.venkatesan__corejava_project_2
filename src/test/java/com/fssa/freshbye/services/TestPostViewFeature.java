package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fssa.freshbye.utils.Logger;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

class TestPostViewFeature {
	 Logger logger = new Logger();
	/*
	 * Its used to list the posts which is post by users 
	 */
	@Test
	void testviewPostValid() throws ServiceException, InvalidPostException, InvalidUserException {
		User user = new User(); 
		user.setUsername("Gopu");
	

		PostService postservice = new PostService();
		

		 
		try {


			List<Post> posts = postservice.viewPost();

			assertNotNull(posts);

			for (Post p : posts) {
				logger.debug(p.toString());
			}

			System.out.println("Successfully Viewed");
		} catch (ServiceException e) {
			logger.error(e);	
			logger.debug(e.getMessage());
		}
	}

	@Test
	void testViewPostInValid() {
		PostService postService = new PostService();

		try {

			List<Post> posts = postService.viewPost();
			assertFalse(posts.isEmpty());

		} catch (ServiceException e) {
			logger.debug(e.getMessage());
		}
	}

} 
