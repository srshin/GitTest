package com.encore.day09;

import java.util.Arrays;

public class Computer implements Cloneable, Comparable<Computer> {
	String model;
	String brand; 
	int price; 
	String[] spec;
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Computer com = (Computer) super.clone();
		com.spec = spec.clone(); //배열 복제
		//String[] spec = new String[this.spec.length];
		//System.arraycopy(this.spec, 0, spec, 0, this.spec.length);
		//com.spec = spec;
		
		return com;
	}

	public Computer(String model, String brand, int price, String[] spec) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "Computer [model=" + model + ", brand=" + brand + ", price=" + price + ", spec=" + Arrays.toString(spec)
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
		result = prime * result + Arrays.hashCode(spec);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (!Arrays.equals(spec, other.spec))
			return false;
		return true;
	}
	@Override
	public int compareTo(Computer com) {
		//return (price - com.price); 
		return model.compareTo(com.model);
	}
	
	
	
	
}
