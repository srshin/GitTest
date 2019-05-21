package valueObject;

public class MajorStudentVO extends VO {
	int studentId;
	String name;
	String skill;
	int majorId;
	String majorTitle;
	public MajorStudentVO(int studentId, String name, String skill, int majorId, String majorTitle) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.skill = skill;
		this.majorId = majorId;
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
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
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
