package com.encore.day09;

public class CellPhone {

	String model; // 핸드폰 모델 번호
	double battery; // 남은 배터리 양

	// 모델 번호를 인자로 받는 생성자
	CellPhone(String model) {
		this.model = model; 
	}
	// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을 감소시킨다.
	// 감소되는 배터리 양 = 통화시간(분) * 0.5
	// 배터리 양은 0보다 작아지지 않는다.
	// 통화 시간(분)이 0보다 작은 경우에는
	//IllegalArgumentException(“통화시간입력오류”)을 발생시킨다.
	void  call(int time) {
		if (time < 0 ) throw new IllegalArgumentException("통화시간입력오류");
		System.out.println("통화시간 : " + time + "분");
		battery -= time* 0.5;
		if (battery < 0 ) battery = 0; 
	}
	
	// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
	// 충전되는 배터리 양 = 충전시간(분) * 3
	// 배터리 양은 100까지만 증가한다.
	// 충전 시간(분)이 0보다 작은 경우에는 
	//IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.
	void  charge(int time) {
		if (time <0) throw new IllegalArgumentException("충전시간입력 오류");
		System.out.println("충전시가 : " + time + "분");
		battery += time* 3;
		if (battery > 100) battery = 100; 
	}
	
	// 남은 배터리 양을 출력한다.
	void  printBattery()
	{
		System.out.println("남은 배터리양 : " + battery);
	}

	// Object 타입의 객체를 입력받고, 입력받은 객체가CellPhone 타입의 클래스이면서 모델 번호가 같은 경우에 true를 리턴한다.
	public boolean  equals(Object otherObject) {
		if (!(otherObject instanceof CellPhone)) return false; 
		return  (((CellPhone)otherObject).model).equals(model) ; 
	}

}
