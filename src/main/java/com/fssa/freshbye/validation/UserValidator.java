
package com.fssa.freshbye.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshbye.model.User;
import com.fssa.freshbye.validation.exceptions.InvalidIdException;
import com.fssa.freshbye.validation.exceptions.InvalidUserException;

public class UserValidator{
	public static boolean validateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user != null && validateName(user.getUsername()) && validateEmail(user.getMail())
				&& validatePassword(user.getPassword()) && validateMobileNo(user.getMobileno())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateUpdateUser(User user) throws InvalidUserException {

//		User is Valid if username is valid and email is valid and pwd is valid
		if (user != null && validateName(user.getUsername()) && validateEmail(user.getMail())
				&& validatePassword(user.getPassword()) && validateMobileNo(user.getMobileno())) {
			return true;
		}

		else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		if (name == null)
			return false;
		String regex = "^[A-Za-z]\\w{2,100}$";
		// This regex matches strings that start with a letter (uppercase or lowercase)
		// and are followed by 2 to 29 word characters (letters, digits, or
		// underscores).
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {

			System.out.println("The user name is valid.");
		} else {
			throw new InvalidUserException("The user name is not valid");

		}

		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null)
			return false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";

		/*
		 * This regex enforces a password policy requiring at least 8 characters,
		 * containing at least one lowercase letter, one uppercase letter, one digit,
		 * one special character (@#$%^&+=), and one non-whitespace character.
		 */

		match = Pattern.matches(patternString, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			throw new InvalidUserException("Invalid password.");

		}

		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null)
			return false;

		String regex = "^.*@.*\\..*$";

		/*
		 * This regex matches strings that have the basic format of an email address,
		 * with at least one "@" symbol followed by at least one period "." symbol.
		 */

		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidUserException("The email address is: Invalid");

		}
		return isMatch;

	}

	public static boolean validateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		/*
		 * This regex matches strings that consist of exactly 10 digits and start with
		 * either 6, 7, 8, or 9. It's commonly used to validate Indian mobile phone
		 * numbers.
		 */

		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			System.out.println("The mobile number is: Valid");
		} else {
			throw new InvalidUserException("The mobile number is: Invalid");

		}
		return isMatch;

	}

	public static void validateId(int id) throws InvalidIdException {

		if (id <= 0) {

			throw new InvalidIdException("Id cannot be zero or below zero");
		}
	}

}
