package valueObject;

public class MajorStudentVO extends VO {
	int studentId;
	String name;
	String skill;
	int major_id;
	String majorTitle;
	public MajorStudentVO(int studentId, String name, String skill, int major_id, String majorTitle) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.skill = skill;
		this.major_id = major_id;
		this.majorTitle = majorTitle;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public String getMajorTitle() {
		return majorTitle;
	}
	public void setMajorTitle(String majorTitle) {
		this.majorTitle = majorTitle;
	}
	@Override
	public String toString() {
		return " [ name=" + name + ", skill=" + skill   + ", major_title=" + majorTitle + "]";
	}
	
	
}
