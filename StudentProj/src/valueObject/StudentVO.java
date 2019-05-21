package valueObject;

public class StudentVO extends VO {
	String studentId;
	String password;
	String name;
	String majorId;
	String phone;
	String address;
	String hobby;
	String skill;
	String majorTitle; 
	
	
	public String getMajorTitle() {
		return majorTitle;
	}
	public void setMajorTitle(String majorTitle) {
		this.majorTitle = majorTitle;
	}
	public StudentVO(String studentId, String password, String name, String majorId, String phone, String address,
			String hobby, String skill, String majorTitle) {
		super();
		this.studentId = studentId;
		this.password = password;
		this.name = name;
		this.majorId = majorId;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.skill = skill;
		this.majorTitle = majorTitle;
	}
	public StudentVO(String studentId, String password, String name, String majorId, String phone, String address,
			String hobby, String skill) {
		super();
		this.studentId = studentId;
		this.password = password;
		this.name = name;
		this.majorId = majorId;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.skill = skill;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "StudentVO [studentId=" + studentId + ", password=" + password + ", name=" + name + ", majorId="
				+ majorId + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby + ", skill=" + skill + "]";
	}



}
