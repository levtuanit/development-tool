package com.mitrais.development.tool.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileHandler {

	public static void copyFile(String source, String destination) throws IOException {
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
		FileUtils.copyFile(sourceFile, destinationFile);
	}

	public static String readFile(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String result = bufferedReader.readLine();
			return result;
		}

	}

	public static void writeToFile(String fileName, String content) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			bufferedWriter.write(content);
		}
	}
}
