package freshBYE.model;

public class User {

	private int UUID;
	private String UserName;
	private String Mobile;
	private String profile;
	public String Email;
	public String password;
	
	public User(String UserName , String Mobile , String profile, String Email, String password) {
		super();
		this.UUID = UUID;
		this.UserName = UserName;
		this.Mobile = Mobile;
		this.profile = profile;
		this.Email = Email;
		this.password = password;
	}
	
	public User(String email, String password) {
		super();
		this.Email = email;
		this.password = password;
	}
	
	public String toString() {
		return "UserID: " + UUID + "username: " + UserName + "mobile_number: " + Mobile + "profileURL: " + profile + "Email: " + Email + " Password: " + password;
	}

	public int getUUID() {
		return UUID;
	}

	public void setUUID(int userID) {
		this.UUID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUsername(String username) {
		this.UserName = username;
	}


	

	public String getMobile_number() {
		return Mobile;
	}

	public void setMobile_number(String mobile_number) {
		this.Mobile = mobile_number;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String date_of_birth) {
		this.profile = date_of_birth;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
