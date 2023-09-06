package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

class TestPostCreateFeature {
//	private final Post post = new Post("Hello", "https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais","As I lay in the hospital bed, surrounded by white walls and medical equipment, a mix of emotions overwhelmed me. Diagnosed with a serious condition after experiencing fatigue and headaches, I faced a challenging journey. The care from dedicated medical professionals, support from family and friends, and moments of joy brought comfort. Each day, I found strength in hope and gratitude, cherishing life's small joys. The hospital became a sanctuary of healing and taught me resilience. Though uncertain, I embraced the path to recovery with courage. This life-altering experience taught me to value health, cherish relationships, and find strength in adversity.");
		
	@Test
	void testCreateValid() throws InvalidPostException, InvalidUserException {
		User user = new User();
		Post post = new Post();
		user.setUsername("Logesh");
	

		
		post.setPostImage(
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais");
		post.setTitle("I am new to freshbye");
		post.setDescription("I am Nervous now");
		post.setUserId(5);
		PostService postservice = new PostService();
		try {
			assertTrue(postservice.createPost(post));
		} catch (ServiceException e) {
 			 e.printStackTrace();
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
			System.out.println("Failed to create an invalid Post");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
