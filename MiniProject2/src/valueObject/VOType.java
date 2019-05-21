package valueObject;

public enum VOType {
	MAJOR("major.csv"),
	STUDENT("student.csv"),
	MAJOR_STUDENT("m_s");
	
	String file;
	VO vo;

	private VOType(String file) {
		this.file = file;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
