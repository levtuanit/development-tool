package com.mitrais.development.tool.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.mitrais.development.tool.utils.FileHandler;
import com.mitrais.development.tool.utils.Message;
import com.mitrais.development.tool.utils.ZipFileHandler;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ServiceImpl implements Service {

	public static final String FALSE = "FALSE";
	public static final String TRUE = "TRUE";
	private static final String DATE_FORMATTER = "yyyyMMdd_HHmmss";

	//
	@Override
	public String unZip(String zipFilePath, String destDir) {
		try {
			ZipFileHandler.unZip(zipFilePath, destDir);
			return TRUE;
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FALSE;
		}
	}

	//
	@Override
	public String zipDirectory(String path, String destDir) {

		try {
			ZipFileHandler.zipDirectory(path, destDir);
			return TRUE;
		} catch (ZipException e) {
			e.printStackTrace();
			return FALSE;
		}
	}

	//
	@Override
	public String copyFile(String source, String destination) {
		File sourceFile;
		File destinationFile;
		try {
			sourceFile = new File(source);
			destinationFile = new File(destination);
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return FALSE;
	}

	//
	@Override
	public String readFile(String fileName) {
		FileReader fileReader;
		BufferedReader bufferedReader;
		String result;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			result = bufferedReader.readLine();
			bufferedReader.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FALSE;
	}

	//
	@Override
	public String writeToFile(String fileName, String content) {
		try {
			FileHandler.writeToFile(fileName, content);
			return TRUE;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FALSE;
		}
	}

	@Override
	public String getMessage(String key) {
		return Message.get(key);
	}

	@Override
	public String createFolder(String src) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
		String createdTime = dateTimeFormatter.format(dateTime);
		File file = new File(src + "\\" + createdTime);
		if (!file.exists()) {
			if (file.mkdir()) {
				return file.getPath();
			}
		}
		return FALSE;
	}

	@Override
	public String copyDirectory(String source, String destination) {
		File sourceFile;
		File destinationFile;
		try {
			sourceFile = new File(source);
			destinationFile = new File(destination);
			FileUtils.copyDirectory(sourceFile, destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return FALSE;
	}

}
