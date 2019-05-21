package com.encore.day10;

public class Box  <T, A, B>{

	T size;
	A material; 
	B color;
	
	
	public Box(T size, A material, B color) {
		super();
		this.size = size;
		this.material = material;
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [size=").append(size).append(", material=").append(material).append(", color=")
				.append(color).append("]");
		return builder.toString();
	}


	public T getSize() {
		return size;
	}
	public void setSize(T size) {
		this.size = size;
	}
	public A getMaterial() {
		return material;
	}
	public void setMaterial(A material) {
		this.material = material;
	}
	public B getColor() {
		return color;
	}
	public void setColor(B color) {
		this.color = color;
	} 
	
	
	
}
