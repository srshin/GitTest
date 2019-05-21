package com.encore.day07;

/*<< 출력 결과 >>
Shape 0 is a BLUE Circle with an area of 314.15927, a radius of 10.0, and a perimeter of 62.831854
Shape 1 is a RED Rectangle with an area of 35.0 and a perimeter of 24.0
Shape 2 is a GREEN Circle with an area of 201.0619328, a radius of 8.0, and a perimeter of 50.2654832
*/
public class TestShape {

	public static void main(String args[])
	{
		Shape[] s = new Shape[3];
		
		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);
		
		for(int i = 0 ; i < 3 ; i++)
		{
			if(s[i] instanceof Circle){
				System.out.println("Shape " + i + " is a " + s[i]
				          + " with an area of " + s[i].calculateArea()
				          + ", a radius of " + ((Circle)s[i]).getRadius()
				          + ", and a perimeter of " + s[i].calculatePerimeter());
			}
			else if(s[i] instanceof Rectangle){
				System.out.println("Shape " + i +  " is a " + s[i] 
				          + " with an area of " + s[i].calculateArea()
				          + " and a perimeter of " + s[i].calculatePerimeter());
			}	
		}	
	}
}
