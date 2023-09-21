package com.fssa.freshbye.validation;

import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

public class CommentValidation {
    static Logger logger = new Logger();

    public static boolean validateUserId(String userId) throws ServiceException {
        if (userId != null && !userId.trim().isEmpty()) {
            logger.debug("The userId is valid.");
            return true;
        } else {
            throw new ServiceException("Invalid userId: " + userId);
        }
    }

    public static boolean validatePostId(int postId) throws ServiceException {
        if (postId > 0) {
            logger.debug("The postId is valid.");
            return true;
        } else {
            throw new ServiceException("Invalid postId: " + postId);
        }
    }

    public static boolean validateCommentId(int commentId) throws ServiceException {
        if (commentId > 0) {
            logger.debug("The commentId is valid.");
            return true;
        } else {
            throw new ServiceException("Invalid commentId: " + commentId);
        }
    }


    public static boolean validateCommentMessage(String commentMessage) throws ServiceException {
        if (commentMessage != null && !commentMessage.trim().isEmpty()) {
            logger.debug("The commentMessage is valid.");
            return true;
        } else {
            throw new ServiceException("Invalid commentMessage: " + commentMessage);
        }
    }
}
