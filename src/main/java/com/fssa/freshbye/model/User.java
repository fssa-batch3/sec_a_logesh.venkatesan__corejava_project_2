package com.fssa.freshbye.model;


public class User {

	private int id;
	private String mail;
	private String username;
	private String password;
	private String mobileno;
	private boolean is_active;
	
 
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}


	public User() { 
	};

	 
	public User(String mail, String username, String password, String mobileno) {

		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
	}

	public User(String userMail, String userPwd) {
		this.mail = userMail;
		this.password = userPwd;
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

	public boolean getIs_active() {
		return is_active;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", username=" + username + ", password=" + password + ", mobileno="
				+ mobileno + ", is_active=" + is_active + "]";
	}

	
	

}
