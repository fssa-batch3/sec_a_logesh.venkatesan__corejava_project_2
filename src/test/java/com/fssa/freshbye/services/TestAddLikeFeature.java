package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

class TestAddLikeFeature {
    Logger logger = new Logger();

    @Test
    void addLikeSuccess() {
        LikeService likeService = new LikeService();

        String userId = "gopikannan@gmail.com";
        int postId = 1;
        try {
            assertTrue(likeService.addLike(userId, postId));
            logger.debug("Successfully added like for post " + postId + " by user " + userId);
        } catch (ServiceException e) {
            logger.debug(e.getMessage());
        }
    }

   
}
