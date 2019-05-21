package com.encore.day12;

public class EmpDTO {
	private String[] element;
	//constructor
	public EmpDTO(String[] element) {
		super();
		this.element = element;
	}

	public void setElement(int i, String str) {
		element[i]=str;  
	}
	public String getElement(int i ) {
		return element[i];
	}
	@Override
	public String toString() {
		String toString=""; 
		for (int i=0; i < element.length; i++) {
			switch(i)  {
			case 4:
				toString +=String.format("%20s", element[i]);
				break;
			case 0:
			case 7:
			case 8:
			case 9:
			case 10:
				toString +=String.format("%9s", element[i]);
				break; 
			case 1:
			case 2:
			case 3:
			case 5:
			case 6:
			default: 
				toString +=String.format("%13s",  element[i]);
				break; 
			}
		}	
		return toString;
	}
}
