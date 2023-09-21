package com.fssa.freshbye.service;

import com.fssa.freshbye.dao.LikeDAO;
import com.fssa.freshbye.dao.exceptions.DAOException;
import com.fssa.freshbye.service.exception.ServiceException;
import com.fssa.freshbye.utils.Logger;

public class LikeService {
    Logger logger = new Logger();

    public boolean likePost(String userId, int postId) throws ServiceException {
        LikeDAO likeDAO = new LikeDAO();

        try {
            return likeDAO.likePost(userId, postId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean addLike(String userId, int postId) throws ServiceException {
        LikeDAO likeDAO = new LikeDAO();

        try {
        	if(userId == null) {
        		throw new ServiceException("Invalid userId" + userId);
        	}
            return likeDAO.addLike(userId, postId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    
    public int getLikeCount(int postId) throws ServiceException {
        LikeDAO likeDAO = new LikeDAO();

        try {
            if(postId <= 0) {
                throw new ServiceException("Invalid postId: " + postId);
            }
            return likeDAO.getLikeCount(postId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
