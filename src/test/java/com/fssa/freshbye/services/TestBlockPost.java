package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.PostService;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

public class TestBlockPost {
	Logger logger = new Logger();

    @Test
    void addLikeSuccess() {
        PostService likeService = new PostService();

        String userId = "gopikannan@gmail.com";
        int postId = 1;
        try {
            assertTrue(likeService.blockPost(userId, postId));
            logger.debug("Successfully added like for post " + postId + " by user " + userId);
        } catch (ServiceException e) {
            logger.debug(e.getMessage());
        }
    }
}
