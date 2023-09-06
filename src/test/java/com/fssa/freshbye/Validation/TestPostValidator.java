package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

 class TestPostValidator {

	@Test
	 void testValidPost() throws InvalidUserException, InvalidPostException {

//		User user = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9028848999", 1234567890, "ABCD0123456",
//				"SOFFANKANNAN", 1);
 

		Post post = new Post("Medical",
				"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais",
				"Help this patient");

		// Set valid attributes for the fundraise

		assertTrue(PostValidation.validatePost(post));
	}

	@Test
	 void testInvalidPost() {

		Post post = new Post(null, null, null);

		// Set invalid attributes for the fundraise

		assertThrows(InvalidPostException.class, () -> {
			PostValidation.validatePost(post);
		});
	}
}
