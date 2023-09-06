package com.fssa.freshbye.Validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.validation.PostValidation;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;

class TestPostImageUrl {
	@Test

	void validProductImage() {
		try {
			assertTrue(PostValidation.validateImageURL(
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			
		} catch (InvalidPostException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test

	void inValidProductImage() {
		try {
			assertFalse(PostValidation.validateImageURL(
					"lll://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			System.out.println("Image URL isn't Valid");
		} catch (InvalidPostException e) {
			assertEquals("The fundraise image URL is not valid.", e.getMessage());
		}
	}
	
		    @Test
		    void emptyImageUrl() {
		        try {
		            assertFalse(PostValidation.validateImageURL(""));
		        } catch (InvalidPostException e) {
		            assertEquals("The fundraise image URL is not valid.", e.getMessage());
		        }
		    }
		
		
	}
