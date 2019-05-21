package com.encore.day18_2;


public class StdDTO {
	int student_id;
	String name;
	String major;
	String skill;
	
	public StdDTO(int student_id, String name, String major, String skill) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.major = major;
		this.skill = skill;
	}
	public StdDTO() {
		super();
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "StdDTO [student_id=" + student_id + ", name=" + name + ", major=" + major + ", skill=" + skill + "]";
	}
	
	
	
}
