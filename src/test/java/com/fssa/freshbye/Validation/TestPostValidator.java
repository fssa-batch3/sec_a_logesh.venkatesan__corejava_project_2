package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestPostValidator {
Logger logger = new Logger();
	@Test
	 void testValidPost() throws InvalidUserException, InvalidPostException {


		Post post = new Post("Medical",
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
				"Help this patient","logesh");

 

		assertTrue(PostValidation.validatePost(post));
	}

	@Test
	void testInvalidPost() throws  InvalidPostException {
	    Post post = new Post(null, null, null,null);
	    try {
			assertFalse(PostValidation.validatePost(post));
		} catch (InvalidUserException e) {
			
			logger.debug(e);
		} catch (InvalidPostException e) {
			logger.debug(e);
			
		}
	}
 }
