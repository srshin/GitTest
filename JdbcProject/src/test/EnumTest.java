package test;

import java.util.Arrays;

class Encore {
	public static final int MONDAY=1;
	public static final int TUESDAY=2;
	public static final int WED=3;
	public static final double PI=3.14;
	
	
	
}

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(Encore.MONDAY);
		System.out.println(100*Encore.PI);
		System.out.println(Week.FRIDAY);
		System.out.println(Arrays.toString(Week.values()));
		System.out.println(Week.valueOf("MONDAY"));
		Week aa = Week.FRIDAY;
		System.out.println(aa.i);
		System.out.println(aa.name);
		
	}
}
