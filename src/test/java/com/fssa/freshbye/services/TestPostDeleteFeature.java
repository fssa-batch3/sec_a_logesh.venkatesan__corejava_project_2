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
		
		Post post = new Post("Hello","https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais","I am new to freshbye");
		PostService postservice = new PostService();
		try {

			int postId = post.getId();

			assertTrue(postservice.deletePost(postId));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Test

	void deleteFundraiseFailed() {
		PostService fundraiseservice = new PostService();
		try {
			assertFalse(fundraiseservice.deletePost(-1));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}
