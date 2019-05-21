package test;

public enum Week {
	MONDAY(1, "월요일"), TUESDAY(2, "화요일"), WEDNESDAY(3, "수요일"), THURSDAY(4, "목요일"), FRIDAY(5, "금요일"), SATURDAY(6, "토요일"), SUNDAY(7, "일요일"); 
	int i; 
	String name;
	Week(int i, String name) {
		
		this.i=i;
		this.name= name; 
	}
	@Override
	public String toString() {
		return name+"즐거워";
	}
	
}
