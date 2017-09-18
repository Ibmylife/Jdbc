package com.njh.utils.bean;

public class TypeConverter {
	public static String contverter(int values){
		switch (values) {
		case -7:
			return "int";
		case -6:
			return "int";
		case -5:
			return "int";
		case -4:
			return "String";
		case -1:
			return "String";
		case 1:
			return "String";
		case 4:
			return "int";
		case 7:
			return "float";
		case 11:
			return "String";
		case 12:
			return "String";
		case 64:
			return "String";
		case 91:
		case 92:
		case 93:
			return "Date";
		
		default:
			return null;
		}
	}
}
