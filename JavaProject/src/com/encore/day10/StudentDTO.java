package com.encore.day10;


//dto : data transfer object
//vo : value object

public class StudentDTO {

	String name; 
	int score;
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 

	
	
}
