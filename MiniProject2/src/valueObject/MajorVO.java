package valueObject;

public class MajorVO extends VO {
	int majorId;
	String majorTitle;
	public MajorVO(int majorId, String majorTitle) {
		super();
		this.majorId = majorId;
		this.majorTitle = majorTitle;
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
		return "[major_id=" + majorId + ", major_title=" + majorTitle + "]";
	}
	
	
}
