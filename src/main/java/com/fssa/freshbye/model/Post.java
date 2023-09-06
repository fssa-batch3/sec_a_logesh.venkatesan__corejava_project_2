package com.fssa.freshbye.model;

public class Post {

    private String postImage;
    private String title;
    private String description;
    private int userId;

    

    // Constructor for view data
    public Post(String postImage, String title, String description) {
        this.postImage = postImage;
        this.title = title;
        this.description = description;
    }

    // Constructor for updating post
    public Post(String postImage, String title, String description, int userId) {
        this.postImage = postImage;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Post() {
	}

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
    
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Post [postImage=" + postImage + ", title=" + title + ", description=" + description + ", userId="
				+ userId + "]";
	}

	public int getId() {
		
		return 0;
	}
}
