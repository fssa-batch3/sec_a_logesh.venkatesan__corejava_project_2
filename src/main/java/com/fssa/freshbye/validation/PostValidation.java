package com.fssa.freshbye.validation;

import java.util.regex.Matcher;
import com.fssa.freshbye.utils.Logger;
import java.util.regex.Pattern;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class PostValidation {
	 static Logger logger = new Logger();


	public static boolean validateDescription(String cost) throws InvalidPostException {
		boolean match = false;

		String regex = "^[\\s\\S]*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(cost);
		match = m.matches();

		if (match) {
			logger.debug("The Description is valid.");
			return true;
		} else {
			throw new InvalidPostException("The Description is valid");
		}

	}

	public static boolean validateImageURL(String imageUrl) throws InvalidPostException {
		boolean match = false;
		String regex = "^(https?|ftp)://.*$";
		match = Pattern.matches(regex, imageUrl);
		if (match) {
			logger.debug("The Post Image URL is valid.");
		} else {
			throw new InvalidPostException("The Post image URL is not valid.");
		}

		return match;
	}

	

	public static boolean validateTitle(String validStory) throws InvalidPostException {
	

		if (validStory != null) {
			logger.debug("The title is valid.");
			return true;
		} else {
			throw new InvalidPostException("The title must not be more than 100 characters.");
		}
	}

	public static boolean validatePost(Post post) throws InvalidUserException, InvalidPostException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (post != null && validateTitle(post.getTitle()) && validateDescription(post.getDescription())
				&& validateImageURL(post.getPostImage()) ) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}   
 
	

}
