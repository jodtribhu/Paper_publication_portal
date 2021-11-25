package utilities;

public class LoginObj {
	public Boolean isLoggedIn;
	public String isFaculty;
	public int LID;
	public String isAdmin;
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public LoginObj(Boolean isLoggedIn, String isFaculty,int LID,String isAdmin) {
		super();
		this.isLoggedIn = isLoggedIn;
		this.isFaculty = isFaculty;
		this.LID=LID;
		this.isAdmin=isAdmin;
	}
	public int getLID() {
		return LID;
	}
	public void setLID(int lID) {
		LID = lID;
	}
	public String getIsFaculty() {
		return isFaculty;
	}
	public void setIsFaculty(String isFaculty) {
		this.isFaculty = isFaculty;
	}
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
}
