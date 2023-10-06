package com.fssa.freshbye.model;

public class Post {

	private String postImage;
	private String title;
	private String description;
	private static String userMail;
	private String username;
	private int postId;

	/*
	 * Constructors Starts here
	 */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static  String getUserMail() {
		return userMail;
	}

	public static String setUserMail(String userMail) {
		return userMail = userMail;
	}

	public Post(String postImage, String title, String description, String Username) {
		this.postImage = postImage;
		this.title = title;
		this.description = description;
		this.username = Username;
	}

	public Post(String postImage, String title, String description, String userMail, int postId2) {
		this.postImage = postImage;
		this.title = title;
		this.description = description;
		this.userMail = userMail;
		this.postId = postId2;
	}

	public Post() {
	}

	/*
	 * Contructors end Here
	 */

	/*
	 * Setters and getters start here
	 */

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setpostId(int postId) {
		this.postId = postId;
	}

	public int getpostId() {

		return postId;
	}

	@Override
	public String toString() {
		return " PostImage=" + postImage + ", Title=" + title + ", Description=" + description + ", UserId="
				+ userMail + ", postId="
						+ postId + "]";
	}

}
