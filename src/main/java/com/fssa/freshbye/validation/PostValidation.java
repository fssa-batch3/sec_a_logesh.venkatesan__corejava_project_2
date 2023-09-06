package com.fssa.freshbye.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshbye.model.Post;
import com.fssa.freshbye.model.User;
import com.fssa.freshbye.validation.exceptions.InvalidPostException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class PostValidation {



	public static <Sting> boolean validateDescription(Sting cost) throws InvalidPostException {
		boolean match = false;

		String regex = "^[\\s\\S]*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher((CharSequence) cost);
		match = m.matches();

		if (match) {
			System.out.println("The Description is valid.");
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
			System.out.println("The Post Image URL is valid.");
		} else {
			throw new InvalidPostException("The Post image URL is not valid.");
		}

		return match;
	}

	

	public static boolean validateTitle(String validStory) throws InvalidPostException {
		int maxLength = 100;

		if (validStory != null) {
			System.out.println("The title is valid.");
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
