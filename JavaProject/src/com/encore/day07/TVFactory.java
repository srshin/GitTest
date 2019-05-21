package com.encore.day07;

public class TVFactory {

	public static TV makeTV(String brand) {
		TV tv = null;
		if (brand.equals("s")) {
			tv = new SamsungTV();
		} else if (brand.equals("L")) {
			tv = new LGTV();
		} 
		return tv; 
	}
}
