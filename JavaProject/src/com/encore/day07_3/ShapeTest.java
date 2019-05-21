package com.encore.day07_3;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] sl = new Shape[2];
		sl[0] = new Rectangle(5, 6);
		sl[1] = new RectTriangle(6, 2);
		for (Shape s : sl) {
			System.out.println("area: " + s.getArea());
			System.out.println("perimeter: " +s.getPerimeter()) ;
			if (s instanceof Rectangle ) {
				((Rectangle)s).resize(0.5);
				System.out.println("new area: " + s.getArea());
				System.out.println("new perimeter: " +s.getPerimeter()) ;
			}
		}
	}
}
