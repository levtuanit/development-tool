package com.mitrais.development.tool.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {

	private static final String MESSAGE_PROPERTIES_PATH = "src/main/resources/message.properties";
	private static final String EMPTY_STRING = "";

	public static String get(String key) {
		try {
			Properties properties = new Properties();

			InputStream input = new FileInputStream(MESSAGE_PROPERTIES_PATH);
			properties.load(input);
			return properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EMPTY_STRING;
	}
}
