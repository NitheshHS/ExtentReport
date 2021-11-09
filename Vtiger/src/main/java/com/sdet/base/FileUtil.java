package com.sdet.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtil {
	
	public static String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.properties");
		Properties properties=new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}

}
