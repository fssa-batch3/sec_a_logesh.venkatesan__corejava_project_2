package com.fssa.freshbye.model;

public class Like {
	private String UserMail;
    private int PostID;
    private boolean IsLiked ;

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
	public boolean isIsLiked() {
		return IsLiked;
	}
	public void setIsLiked(boolean isLiked) {
		IsLiked = isLiked;
	}
   
	@Override
	public String toString() {
		return "Like [UserMail=" + UserMail + ", PostID=" + PostID + ", IsLiked=" + IsLiked + ", getUserMail()="
				+ getUserMail() + ", getPostID()=" + getPostID() + ", isIsLiked()=" + isIsLiked() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
