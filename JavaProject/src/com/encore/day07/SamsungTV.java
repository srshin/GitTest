package com.encore.day07;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "전원을 켠다 ");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "전원을 끈다 ");

	}
	public void good () {
		System.out.println(SBS + "화질이 좋아요");
	}

}
