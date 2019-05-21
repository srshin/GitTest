package com.encore.day07;

public class File extends Entry {

	public File(String name, int size) {
		super(name, size);
	}

	@Override
	public void print() {
		System.out.println(getName()+"("+getSize()+")");
	}
	

	
	
	
	
}
