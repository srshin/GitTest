package com.encore.day11;

public class BathTread extends Thread {
	String name; 
	BathRoom room;
	
	@Override
	public void run() {
		for (int i=1; i<=3; i++) {
			room.use(name);
		}
	}
	public BathTread(String name, BathRoom room) {
		super();
		this.name = name;
		this.room = room;
	} 
}
