package utilities;

public class LoginObj {
	public Boolean isLoggedIn;
	public String isFaculty;
	public int LID;
	public int s_id;
	public int f_id;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String isAdmin;
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public LoginObj(Boolean isLoggedIn, String isFaculty,int LID,String isAdmin,int s_id,int f_id) {
		super();
		this.isLoggedIn = isLoggedIn;
		this.isFaculty = isFaculty;
		this.LID=LID;
		this.isAdmin=isAdmin;
		this.s_id=s_id;
		this.f_id=f_id;
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
