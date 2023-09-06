package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;

class TestPostUpdateFeature {

	@Test
	void testUpdateSuccess() {


		PostService Postservice = new PostService();

		try {
			int postId = Postservice.postGetPostId();

			Post post = new Post( "Education",
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
					"Help this patient");

			assertTrue(Postservice.updatePost(post));
			

		} catch (ServiceException e) {
			
			e.printStackTrace();

		}
	}

	@Test
	void testUpdateFail() {

		PostService postservice = new PostService();
		Post post = new Post(null, null, null);
		try {

			assertFalse(postservice.updatePost(post));

		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}
}
