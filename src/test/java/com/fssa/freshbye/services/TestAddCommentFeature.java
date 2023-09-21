package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

class TestAddCommentFeature {
    Logger logger = new Logger();

    @Test
    void addCommentSuccess() {
        CommentService commentService = new CommentService();

        String userId = "gopikannan@gmail.com";
        int postId = 1;
        int commentId = 1;
        String commentMessage = "This is a test comment.";
        try {
            assertTrue(commentService.addComment(userId, postId, commentId, commentMessage));
            logger.debug("Successfully added comment for post " + postId + " by user " + userId);
        } catch (ServiceException e) {
            logger.debug(e.getMessage());
        }
    }
}
