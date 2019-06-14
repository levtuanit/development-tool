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
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileHandler {

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

		try (ZipFile file = new ZipFile(zipPath)) {
			final Enumeration<? extends ZipEntry> entries = file.entries();
			while (entries.hasMoreElements()) {
				final ZipEntry fullPath = entries.nextElement();
				String pathWithoutRootFolder = getPathWithoutRootFolder(fullPath.getName());
				pathsInZip.put(pathWithoutRootFolder, pathWithoutRootFolder);
			}
		}

		return pathsInZip;
	}

	private static String getPathWithoutRootFolder(String fullPath) {
		int firstSplashIndex = fullPath.indexOf("/");
		return fullPath.substring(firstSplashIndex, fullPath.length());
	}
}
