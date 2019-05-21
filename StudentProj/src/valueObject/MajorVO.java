package valueObject;

public class MajorVO extends VO {
	String majorId;
	String majorTitle;
	
	public MajorVO(String majorId, String majorTitle) {
		super();
		this.majorId = majorId;
		this.majorTitle = majorTitle;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
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
