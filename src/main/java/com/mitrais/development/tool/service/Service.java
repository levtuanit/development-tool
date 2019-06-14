package com.mitrais.development.tool.service;

public interface Service {
	
	String unZip(String zipFilePath, String destDir);

	String zipDirectory(String path, String destDir);

	String copyFile(String source, String destination);

	String readFile(String fileName);

	String writeToFile(String fileName, String content);
	
	String getMessage(String key);
	
	String createFolder(String src);
	
	String copyDirectory(String source, String destination);
}
