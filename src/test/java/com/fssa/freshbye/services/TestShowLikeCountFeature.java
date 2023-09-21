package com.fssa.freshbye.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.freshbye.service.*;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

class TestShowLikeCountFeature {
    Logger logger = new Logger();

    @Test
    void getLikeCountSuccess() {
        LikeService likeService = new LikeService();

        int postId = 2;
        try {
            int likeCount = likeService.getLikeCount(postId);
            assertTrue(likeCount >= 0);
            logger.debug("Successfully retrieved like count for post " + postId + ": " + likeCount);
        } catch (ServiceException e) {
            logger.debug(e.getMessage());
        }
    }
}
