package com.mitrais.development.tool.utils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipFileHandler {

	private static final String FORWARD_SLASH = "/";

	public static void unZip(String zipFilePath, String destDir) throws ZipException {
		ZipFile zipFile = new ZipFile(zipFilePath);
		zipFile.extractAll(destDir);
	}

	public static void zipDirectory(String path, String destDir) throws ZipException {
		ZipParameters parameters = new ZipParameters();
		// set compression method to store compression
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		// Set the compression level
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		ZipFile zipFile = new ZipFile(destDir + CommonConstant.ZIP_EXTENSION);
		zipFile.addFolder(path, parameters);
	}

	public static boolean checkValid(String zipPath) throws IOException {
		if (!checkIfZipFile(zipPath)) {
			return false;
		}
		Map<String, String> pathsInZip = readPathsFromZipFile(zipPath);
		List<String> correctStructure = getCorrectStructure(zipPath);
		return checkIfZipFileHaveCorrectFolders(pathsInZip, correctStructure);
	}

	private static boolean checkIfZipFile(String path) throws IOException {
		File file = new File(path);
		if (file.isDirectory()) {
			return false;
		}
		if (!file.canRead()) {
			throw new IOException("Cannot read file " + file.getAbsolutePath());
		}
		if (file.length() < 4) {
			return false;
		}
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		int test = in.readInt();
		in.close();
		return test == 0x504b0304;
	}

	private static boolean checkIfZipFileHaveCorrectFolders(Map<String, String> pathsInZip,
			List<String> correctStructure) {
		for (String item : correctStructure) {
			String value = pathsInZip.get(item);
			if (value == null)
				return false;
		}
		return true;
	}

	private static List<String> getCorrectStructure(String zipPath) {
		List<String> correctStructure = new ArrayList<String>();

		correctStructure.add("/common/");
		correctStructure.add("/common/backup/");
		correctStructure.add("/common/install/");
		correctStructure.add("/common/rollback/");
		correctStructure.add("/production/");
		correctStructure.add("/production/backup/");
		correctStructure.add("/production/install/");
		correctStructure.add("/production/rollback/");
		correctStructure.add("/testing/");
		correctStructure.add("/testing/backup/");
		correctStructure.add("/testing/install/");
		correctStructure.add("/testing/rollback/");
		return correctStructure;
	}

	private static Map<String, String> readPathsFromZipFile(String zipPath) throws IOException {
		// Map<Path, Path>
		Map<String, String> pathsInZip = new HashMap<String, String>();

		try (java.util.zip.ZipFile file = new java.util.zip.ZipFile(zipPath)) {
			final Enumeration<? extends java.util.zip.ZipEntry> entries = file.entries();
			while (entries.hasMoreElements()) {
				final java.util.zip.ZipEntry fullPath = entries.nextElement();
				String pathWithoutRootFolder = getPathWithoutRootFolder(fullPath.getName());
				pathsInZip.put(pathWithoutRootFolder, pathWithoutRootFolder);
			}
		}

		return pathsInZip;
	}

	private static String getPathWithoutRootFolder(String fullPath) {
		int firstSplashIndex = fullPath.indexOf(FORWARD_SLASH);
		return fullPath.substring(firstSplashIndex, fullPath.length());
	}
}
