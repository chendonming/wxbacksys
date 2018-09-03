package com.lzs.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 * 属性配置文件读取类
 */
public class ProUtil {
	private static ResourceLoader resourceLoader = new DefaultResourceLoader();

	public static String getValue(String keyName, String fileName) {
		String value = "";
		Properties propertie = new Properties();
		try {
			String path = "properties/" + fileName;
			Resource resource = resourceLoader.getResource(path);
			InputStream inputStream = resource.getInputStream();
			BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
			propertie.load(buff);
			inputStream.close();
			value = propertie.getProperty(keyName, "获取失败");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args) {
		System.out.println("--->" + ProUtil.getValue("jdbc_username", "jdbc.properties")); // username
	}
}
