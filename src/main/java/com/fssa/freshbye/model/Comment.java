package com.fssa.freshbye.model;

public class Comment {
    private String UserMail;
    private int PostID;
    private int CommentId;
    private String CommentMessage;

    public String getUserMail() {
        return UserMail;
    }
    public void setUserMail(String userMail) {
        UserMail = userMail;
    }
    public int getPostID() {
        return PostID;
    }
    public void setPostID(int postID) {
        PostID = postID;
    }
    public int getCommentId() {
        return CommentId;
    }
    public void setCommentId(int commentId) {
        CommentId = commentId;
    }
    public String getCommentMessage() {
        return CommentMessage;
    }
    public void setCommentMessage(String commentMessage) {
        CommentMessage = commentMessage;
    }

    @Override
    public String toString() {
        return "Comment [UserMail=" + UserMail + ", PostID=" + PostID + ", CommentId=" + CommentId + ", CommentMessage=" + CommentMessage + "]";
    }
}
