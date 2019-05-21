package com.encore.day09;

import java.util.Arrays;

public class Car implements Cloneable{

	private String model;
	private int price;
	String[] acc;
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Car c = (Car)super.clone();
		String[] acc = new String[this.acc.length];
		System.arraycopy(this.acc, 0, acc, 0, this.acc.length);
		c.acc = acc;
		return c;
		
	}
	
	
	
	
	public Car(String model, int price, String[] acc) {
		super();
		this.model = model;
		this.price = price;
		this.acc = acc;
	}

	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + ", acc=" + Arrays.toString(acc) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + price;
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
		Car other = (Car) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	
}
