package com.encore.day18;


public class PSDTO {

	private int studentId;
	private String name;
	private String major;
	private String itSkill;
	
	public PSDTO(int studentId, String name, String major, String itSkill) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.itSkill = itSkill;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getItSkill() {
		return itSkill;
	}
	public void setItSkill(String itSkill) {
		this.itSkill = itSkill;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PSDTO [studentId=").append(studentId).append(", name=").append(name).append(", major=")
				.append(major).append(", itSkill=").append(itSkill).append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itSkill == null) ? 0 : itSkill.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + studentId;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PSDTO other = (PSDTO) obj;
		if (itSkill == null) {
			if (other.itSkill != null)
				return false;
		} else if (!itSkill.equals(other.itSkill))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	
	
}
