package com.encore.self;

public class StringToInt {

	
	public static void breakString (String text, String[] textlist) {
		char space=' ';
		int index=0; 
		int i = 0; 
		String text1;
		text1 = text;
		while(true) {
			index = text1.indexOf(space);
			if (index <0) break;
			//System.out.println(index);
			textlist[i]=text1.substring(0, index);
			text1= text1.substring(index+1);
			System.out.print(textlist[i]);
			i++;
		}
		System.out.println();
		return;
	}
	public static boolean findString(String text, String[] textlist) {
		for (int i=0 ; textlist[i] != null; i++) {
			if(text.equals(textlist[i])) {
				return true;
			}
		}
		return false; 
	}
	public static void main(String[] args) {
		String text = "The default color class used in W3.CSS is inspired by Material Design.\r\n" + 
				"\r\n" + 
				"Material Design colors reflect the colors used in marketing, road signs, and sticky notes." ;
		String[] textlist =  new String[100];
		breakString(text, textlist);
		//for(int i=0; textlist[i]!=null; i++) System.out.print(textlist[i]);
		System.out.println(findString("default4", textlist));
	}
}
