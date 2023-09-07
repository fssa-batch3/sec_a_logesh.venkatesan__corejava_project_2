package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.model.*;
class TestPostDeleteFeature {
	@Test

	void deletePostSuccess() {
		
		PostService postservice = new PostService();
		try {

			int postId = 7;

			assertTrue(postservice.deletePost(postId));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
 
	}

	@Test

	void deletePostFailed() {
		PostService postservice = new PostService();
		try {
			assertFalse(postservice.deletePost(-1));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}
