package com.mitrais.development.tool.service;

public interface Service {
	String unZip(String zipFilePath, String destDir);

	String zipDirectory(String path, String destDir);

	String copyFile(String source, String destination);

	String readFile(String fileName);

	String wirteFile(String fileName, String content);

}
