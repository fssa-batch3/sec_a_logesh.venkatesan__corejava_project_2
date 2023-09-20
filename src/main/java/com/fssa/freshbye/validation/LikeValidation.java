package com.fssa.freshbye.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.freshbye.utils.Logger;
import com.fssa.freshbye.validation.exceptions.InvalidLikeException;

public class LikeValidation {
    static Logger logger = new Logger();

    public static boolean validateUserId(String userId) throws InvalidLikeException {
        boolean match = false;

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userId);
        match = m.matches();

        if (match) {
            logger.debug("The UserMail is valid.");
            return true;
        } else {
            throw new InvalidLikeException("The UserMail is not valid.");
        }
    }

    public static boolean validatePostId(int postId) throws InvalidLikeException {
        if (postId > 0) {
            logger.debug("The PostID is valid.");
            return true;
        } else {
            throw new InvalidLikeException("The PostID must be greater than 0.");
        }
    }
}