package valueObject;

public class UserInfoVO  extends VO {

	String UserId ;
	String userPassword;
	public UserInfoVO(String userid, String userpassword) {
		super();
		UserId = userid;
		this.userPassword = userpassword;
	}
	public String getUserid() {
		return UserId;
	}
	public void setUserid(String userid) {
		UserId = userid;
	}
	public String getUserpassword() {
		return userPassword;
	}
	public void setUserpassword(String userpassword) {
		this.userPassword = userpassword;
	}
	@Override
	public String toString() {
		return "UserVO [Userid=" + UserId + ", userpassword=" + userPassword + "]";
	}
	
	
	
	
	
}
