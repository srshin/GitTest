package com.encore.day08;

import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		ArrayList<Shape>li = new ArrayList<>();
		li.add(new Rectangle(5, 6));
		li.add(new RecTriangle(6, 2));
		for (Shape a : li) {
			System.out.println("area " + a.getArea());
			System.out.println("perimeter "+ a.getPerimeter());
			if (a instanceof Resizable) {
				((Resizable) a).resize(0.5);
				System.out.println("new area " + a.getArea());
				System.out.println("new perimeter " + a.getPerimeter());
			}
		}
	}
}
