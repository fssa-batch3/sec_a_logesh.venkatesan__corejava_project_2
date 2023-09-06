package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;

 class TestPostTitle {
	@Test
	void testValidTitle() throws InvalidPostException {
		String validStory = "Hello World";
		assertTrue(PostValidation.validateDescription(validStory));
	}

	@Test 
	void testInValidTitle() throws InvalidPostException {
		String title = "duwheihfwuihfhweiufhiwehfuihewuifhuiehfuihweuifhuiwheuiweuifuihweiufhiuwehufhweihfuiwehufhuhefhueihuiwehfuiweuibbeiubuifhiwhfiuhuehfiwhefuhwiehfiwheifhweiuhfihehihuifhhanjknjkcnaknkannfweuifhguihwioweifwiefiwefuhwefuehwuehfuiwehfuwefuhsihasiochoiahsciohasoichaioschioashcoiahsicohasiohcioashciohaioschioascioahcioaiochoiahoiahsiioahscoihaiohioahsiohcaioaoishcoihaiscbwufseufhwuefhuwebfuw7u";
		assertFalse(PostValidation.validateDescription(title));
	}

}
