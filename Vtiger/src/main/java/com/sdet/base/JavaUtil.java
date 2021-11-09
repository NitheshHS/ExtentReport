package com.sdet.base;

import java.util.Date;

public class JavaUtil {
	
	public static String getSystemDate() {
		Date date=new Date();
		
		return date.toString().replaceAll(" ", "_").replace(":", "_");
	}
	

}
