package com.encore.day07;

public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println(getClass().getSimpleName() + "전원을 켠다 ");
	}

	@Override
	public void powerOff() {
		System.out.println(getClass().getSimpleName() + "전원을 끈다 ");

	}
	public void great() {
		System.out.println(KBS + "더더더 잘 나돠요 .......");
	}

}
