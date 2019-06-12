package com.mitrais.development.tool.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

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
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(zipFilePath);
			zipFile.extractAll(destDir);
			return TRUE;
		} catch (ZipException e) {
			e.printStackTrace();
		}
		return FALSE;
	}

	//
	@Override
	public String zipDirectory(String path, String destDir) {

		ZipFile zipFile;
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
		String timeForZip = dateTimeFormatter.format(dateTime);

		// Zip parameters
		ZipParameters parameters = new ZipParameters();
		// set compression method to store compression
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		// Set the compression level
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		try {
			zipFile = new ZipFile(destDir + "_" + timeForZip + ".zip");
			zipFile.addFolder(path, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FALSE;
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
	public String wirteFile(String fileName, String content) {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(content);
			bufferedWriter.close();
			return TRUE;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return FALSE;
	}

}
