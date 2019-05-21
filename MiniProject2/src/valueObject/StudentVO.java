package valueObject;

public class StudentVO extends VO {
	int studentId;
	String name;
	int major_id;
	String phone;
	String address;
	String hobby;
	String skill;
	public StudentVO(int studentId, String name, int major_id, String phone, String address, String hobby,
			String skill) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.major_id = major_id;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.skill = skill;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
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
		return " [student_id=" + studentId + ", sname=" + name + ", major_id=" + major_id + ", phone=" + phone
				+ ", address=" + address + ", hobby=" + hobby + ", skill=" + skill + "]";
	}
	
	
	
}
