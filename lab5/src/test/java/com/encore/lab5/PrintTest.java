package com.encore.lab5;

import org.apache.hadoop.io.Text;
import org.relaxng.datatype.Datatype;

public class PrintTest {

	public static String findDataType(String string) {
		if (string == null)			return "Null";
		if (string.equals(""))			return "Blank";

		String type = "Integer";
		for (char a : string.toCharArray()) {
			if (!Character.isDigit(a)) {
				type = "Float";
				break;
			}
		}
		if (type.equals("Integer"))			return "Integer";
		for (char a : string.toCharArray()) {
			if (!(Character.isDigit(a) || a == '.')) {
				type = "String";
				break;
			}
		}
		if (type.equals("Float"))			return "Float";
		return "String";

	}

	

	public static void main(String[] args) {
		String[] list = { "11111.111", "EMPLOYEE_ID", "3333333", "", null };
		for (String s : list) {
			switch (findDataType(s)) {
			case "Null":
				System.out.println("Null");
				break;
			case "Blank":
				System.out.println("Blank");
				break;
			case "String":
				System.out.println(s);
				break;
			case "Float":
				System.out.println(Float.valueOf(s));
				break;
			case "Integer":
				System.out.println(Integer.valueOf(s));
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}

	}

}
