package com.fssa.freshbye.Validation;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;

 class TestPostDescription {

	@Test
	void testValidCause() throws InvalidPostException {
		String validStory = "Hello World";
		assertTrue(PostValidation.validateTitle("Hello World"));
	}

	@Test
	void testInValidCause() throws InvalidPostException {
		String validStory = "dehfviowhefuihweuifhwuiehuiwhuifhiuwhfuhweiufhqiuwhfuiwheuihqiwuefhuiqwhefuiweufwuiebfgubwufbuwguwehgiuwhguihwioweifwiefiwefuhwefubweufhwuehwuehfuiwehfuwefubwufseufhwuefhuwebfuw7u";
		assertFalse(PostValidation.validateTitle(validStory));
	}
	

 
   
}
