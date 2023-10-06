package com.fssa.freshbye.model;


public class User {

	private int id;
	private String mail;
	private String username;
	private String password;
	private String mobileno;
	private static String profileImage;
	private boolean isActive;
	private boolean isDeleted;
	
	
	
	
	
	
	public boolean isDeleted() {
		return isDeleted;
	}


	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public static String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}





	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	
	
	
 
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}


	

	 
	public User(String mail, String username, String password, String mobileno,String profileImage) {

		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.profileImage=profileImage;
	}

	public User(String userMail, String userPwd) {
		this.mail = userMail;
		this.password = userPwd;
	}

	
	public User() {
		
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public boolean getIsActive() {
		return isActive;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", username=" + username + ", password=" + password + ", mobileno="
				+ mobileno + ", profileImage=" + profileImage + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ "]";
	}



	

	
	

}
