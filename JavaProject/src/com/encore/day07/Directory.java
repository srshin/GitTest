package com.encore.day07;

public class Directory extends Entry {

	public Directory(String name) {
		super(name, 0);
	}

	@Override
	public void print() {
		System.out.println(getName());
	}
	

	
	
	
	
}
