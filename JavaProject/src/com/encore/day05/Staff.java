package com.encore.day05;
/*1. Employee 클래스는 다음과 같은 필드를 가집니다.
멤버변수 name : String : private
         title : String : private
         baseSalary : int : private
         totalSalary : int : private
2. Employee 클래스는 다음과 같은 생성자를 가집니다.
public Employee(String name, String title, int baseSalary) {
3개의 매개변수를 차례대로 같은 이름의 멤버변수 값으로 초기화하는 문장 정의
}
3. Employee 클래스는 다음과 같은 메소드를 가집니다.
3-1. public void getTotalSalary() 메소드 :  
title 이 “부장” 이면 totalSalary 는 baseSalary + baseSalary 의 25%로 계산
title 이 “과장” 이면 totalSalary 는 baseSalary + baseSalary 의 15%로 계산 
나머지 totalSalary 는 baseSalary + baseSalary 의 5%로 계산
3-2. public void print() 메소드 : 
Exam01 클래스 실행 예의 결과대로 title, name, baseSalary, totalSalary 를 출력
부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.
*/

//JavaBeans
//규격서 : 멤버 변수는 접근 제한자를 private --- 정보 은닉
public class Staff {
	private String name ;
	private String title ; 
    private int baseSalary ;
    private int totalSalary ;

    public Staff() {} 
    public Staff(String name, String title, int baseSalary) {
    	//3개의 매개변수를 차례대로 같은 이름의 멤버변수 값으로 초기화하는 문장 정의
    	this.name = name;
    	this.title = title; 
    	this.baseSalary = baseSalary;
    	getTotalSalary(title);
    }
    
    public String getName( ) {
    	return name;
    }
    
    public String getTitle () {
    	return title; 
    }
    
    public void setName (String name)
    {
    	this.name = name ;   
    	}
    
    
    public void getTotalSalary(String title) {  
    	if (title.equals("부장")) 
    		totalSalary = baseSalary + (int)(baseSalary *0.25);
    	else if (title.equals("과장"))
    		totalSalary = baseSalary + (int)(baseSalary *0.15);
    	else
    		totalSalary = baseSalary + (int)(baseSalary *0.05);
       	//System.out.println(title +  totalSalary);
    }
    	
    public void print() { 
    	System.out.printf("%s 직급의 %s씨의 본봉은  %d이고 총급여는 %d\n", title, name, baseSalary, totalSalary);
    	    }
}
