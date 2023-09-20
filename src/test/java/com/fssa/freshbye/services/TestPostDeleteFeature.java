package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fssa.freshbye.utils.Logger;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;



class TestPostDeleteFeature {
	 Logger logger = new Logger();	
	
	@Test

	void deletePostSuccess() {
		
		PostService postservice = new PostService();
		try {

			int postId = 2;
 
			assertTrue(postservice.deletePost(postId));
		} catch (ServiceException e) {
			logger.error(e);	
			logger.debug(e.getMessage());
		}
 
	}

	@Test

	void deletePostFailed() {
		PostService postservice = new PostService();
		try {
			assertFalse(postservice.deletePost(-1));
		} catch (ServiceException e) {
			logger.debug(e.getMessage());
		}

	}

}
