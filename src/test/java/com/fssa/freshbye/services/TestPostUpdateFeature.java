package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fssa.freshbye.utils.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;

class TestPostUpdateFeature {
	 Logger logger = new Logger();
	@Test
	void testUpdateSuccess() {

		PostService Postservice = new PostService();

		try {

			Post post = new Post();
			post.setPostImage(
					"https://welcome-to-freshbye-dude");
			post.setTitle("Happy Holi");
		 	post.setDescription("I am enjoy the fest of Holi in my college with my friends😊😊😊❤️");
			post.setUserMail("gopikannan@gmail.com");
			post.setpostId(1);
 
			assertTrue(Postservice.updatePost(2, post));

		} catch (ServiceException e) {

			logger.error(e);	

		}
	}

	@Test
	void testUpdateFail() {

		PostService postservice = new PostService();
		Post post = new Post(null, null, null,null);
		try {

			assertFalse(postservice.updatePost(9, post));

		} catch (ServiceException e) {
			logger.debug(e.getMessage());

		}
	}
}
