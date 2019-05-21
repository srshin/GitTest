package model;

public enum Gender {
	M("남자"), F("여자");
	final String name;
	
	Gender(String name) {
		this.name = name; 
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
	
	
}
