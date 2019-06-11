package com.mitrais.development.tool.service;

public interface Service {
	String unzip(String zipFilePath, String destDir);
	
	String copyFile();
	
	String readFile(String filePath);
	
//	String selectFolder();
}
