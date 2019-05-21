package com.encore.day09;


//JavaBeans기술 규격서
//멤버변수는 접근제한자를 private으로 한다. 
//default 생성자는 필수로 만든다. 
// getter setter 생성 필수 
public class Person {
	private String name;
	private String gender;
	private int age;
	public Person() {}
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) return false; 
		
		Person p = (Person)obj;
		return (age == p.age && name.equals(p.name) && gender.equals(p.gender)); 
		
	} 
	
	
	
}
