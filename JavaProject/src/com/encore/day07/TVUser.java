package com.encore.day07;

public class TVUser {
	public static TV makeTV(String brand) {
		if (brand.equals("s")) return new SamsungTV();
		else return new LGTV();
	}
	public static void main (String args) {
		TV tv = TVFactory.makeTV("s");
		tv.powerOn();
		tv.powerOff();
		if (tv instanceof LGTV) {
			((LGTV)tv).great();
		}
		else if (tv instanceof SamsungTV) {
			((SamsungTV)tv).good();
		}
	}

		
		
		
}
