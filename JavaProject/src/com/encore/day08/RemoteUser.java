package com.encore.day08;

public class RemoteUser {
	public static void work(RemoteControl r) {
		r.turnOn();
		r.turnOff();
		r.setting();
	}
	
	public static void main(String[] args) {
		RemoteControl.print();
		Parent p = new Television();
		RemoteControl r = new Refig();
		work((RemoteControl)p);
		work(r);
	}
}
